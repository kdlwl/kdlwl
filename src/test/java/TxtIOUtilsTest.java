import paper_check.SimHash_;
import paper_check.file.TxtIOUtils;


    public class TxtIOUtilsTest {
        @org.junit.Test
        public void readTxtTest() {
            // 路径存在，正常读取
            String str = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig.txt");
            String[] strings = str.split(" ");
            for (String string : strings) {
                System.out.println(string);
            }
        }

        @org.junit.Test
        public void writeTxtTest() {
            // 路径存在，正常写入
            double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
            for (int i = 0; i < elem.length; i++) {
                TxtIOUtils.writeTxt(elem[i], "1","2","D:\\Download\\java_idea\\ppcheck\\ans.txt");
            }
        }

        @org.junit.Test
        public void readTxtFailTest() {
            // 路径不存在，读取失败
            String str = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\none.txt");
        }

        @org.junit.Test
        public void writeTxtFailTest() {
            // 路径错误，写入失败
            double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
            for (int i = 0; i < elem.length; i++) {
                TxtIOUtils.writeTxt(elem[i], "1","2","D:/test/ans.txt");
            }
        }
    }



