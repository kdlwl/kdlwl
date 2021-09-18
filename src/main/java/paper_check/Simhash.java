package paper_check;
import java.math.BigInteger;
import java.util.List;
public interface Simhash {
    BigInteger simhash();
    BigInteger hash(String source);      //哈希值
    int hammingDistance(SimHash_ other); //汉明距离
    double getDistance(String str1, String str2);
    List subByDistance(SimHash_ simHash_,int distance); //特征值

}
