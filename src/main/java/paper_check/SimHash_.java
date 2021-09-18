package paper_check;
import paper_check.file.TxtIOUtils;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SimHash_ implements  Simhash{
    public String tokens;
    public BigInteger intSimHash;
    public String strSimHash;
    public int hashbits = 64;
    public SimHash_(String tokens, int hashbits) {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.intSimHash = this.simhash();
    }
    public BigInteger simhash() {
        // 定义特征向量/数组
        int[] v = new int[this.hashbits];
        StringTokenizer stringTokens = new StringTokenizer(this.tokens);
        while (stringTokens.hasMoreTokens()) {
            String temp = stringTokens.nextToken();
            //2、将每一个分词hash为一组固定长度的数列.比如 64bit 的一个整数.
            BigInteger t = this.hash(temp);
            for (int i = 0; i < this.hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                // 3、建立一个长度为64的整数数组(假设要生成64位的数字指纹,也可以是其它数字),
                // 对每一个分词hash后的数列进行判断,如果是1000...1,那么数组的第一位和末尾一位加1,
                // 中间的62位减一,也就是说,逢1加1,逢0减1.一直到把所有的分词hash数列全部判断完毕.
                if (t.and(bitmask).signum() != 0) {
                    v[i] += 1;
                } else {
                    v[i] -= 1;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        StringBuffer simHashBuffer = new StringBuffer();
        for (int i = 0; i < this.hashbits; i++) {
            // 4、最后对数组进行判断,大于0的记为1,小于等于0的记为0,得到一个 64bit 的数字指纹/签名.
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
                simHashBuffer.append("1");
            }else{
                simHashBuffer.append("0");
            }
        }
        this.strSimHash = simHashBuffer.toString();
        setStrSimHash(strSimHash);
        return fingerprint;
    }

    public String getStrSimHash() {

        return strSimHash;
    }

    public void setStrSimHash(String strSimHash) {
        this.strSimHash = strSimHash;
    }

    public BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(
                    new BigInteger("1"));
            for (char item : sourceArray) {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    public int hammingDistance(SimHash_ other) {

        BigInteger x = this.intSimHash.xor(other.intSimHash);
        int tot = 0;

        //统计x中二进制位数为1的个数
        //我们想想，一个二进制数减去1，那么，从最后那个1（包括那个1）后面的数字全都反了，对吧，然后，n&(n-1)就相当于把后面的数字清0，
        //我们看n能做多少次这样的操作就OK了。

        while (x.signum() != 0) {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }

    public double getDistance(String str1, String str2) {
        double distance;
        if (str1.length() != str2.length()) {
            distance = -1;
        } else {
            distance = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }


    public List subByDistance(SimHash_ simHashImpl, int distance){

        int numEach = this.hashbits/(distance+1);
        List characters = new ArrayList();

        StringBuffer buffer = new StringBuffer();

        int k = 0;
        for( int i = 0; i < this.intSimHash.bitLength(); i++){
            // 当且仅当设置了指定的位时，返回 true
            boolean sr = simHashImpl.intSimHash.testBit(i);

            if(sr){
                buffer.append("1");
            }
            else{
                buffer.append("0");
            }

            if( (i+1)%numEach == 0 ){
                // 将二进制转为BigInteger
                BigInteger eachValue = new BigInteger(buffer.toString(),2);
                buffer.delete(0, buffer.length());
                characters.add(eachValue);
            }
        }
        return characters;
    }

//    public double distance(String strSimHash1,String strSimHash2){
//        double distance;
//        return hash1.getDistance(hash1.strSimHash,hash2.strSimHash);
//    }



}
