package model;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.json.JSONException;

import model.*;

public class Main {
    public static void main(String[] args) throws JSONException, URISyntaxException {
        // 创建BasicInformation对象并传入参数
        BasicInformation basicInformation = new BasicInformation("John", 25, "XYZ University", "Computer Science", "2015-09", "2019-06");
        System.out.println("aaa");

        // 获取BasicInformation类的保护域
        URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        // 获取程序文件所在的目录
        String classDirectory = Paths.get(classResource.toURI()).getParent().toString();
        // 拼接图片文件名
        File imageFile = new File(classDirectory + File.separator + "C-tdd1.png");

        // 保存基本信息并传入图片文件
        String savedPath = basicInformation.saveBasicInformation(imageFile);
        System.out.println("基本信息已保存至：" + savedPath);
        System.out.println("bbb");

        // 获取基本信息
        String basicInfo = BasicInformation.getBasicInformation();
        System.out.println("基本信息为：" + basicInfo);

        // 删除基本信息及图片
        boolean isDeleted = basicInformation.deleteBasicInformation();
        if (isDeleted) {
            System.out.println("基本信息及图片已成功删除。");
        } else {
            System.out.println("删除失败。");
        }
    }

}
