package com.pm.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * RandomCode验证码可以通过静态方法和实例方法生成。
 *
 * 静态方法：
 *
 * //生成长度为4的随机验证码
 * String code = RandomCode.randomString(4);
 *
 * //把验证码图片输入到response输出流中
 * //图片格式jpg
 * OutputStream os = response.getOutputStream();
 * RandomCode.write(code, 120, 30, os, "jpg");
 *
 * 实例方法：
 *
 * //实例化验证码类
 * RandomCode rc = new RandomCode(4);
 *
 * //把验证码图片输入到response输出流中
 * //图片格式jpg
 * OutputStream os = response.getOutputStream();
 * rc.write(120, 30, os, "jpg");
 *
 * //获取验证码字符串
 * String code = rc.getCode();
 *
 */
public class RandomCode {
    /**
     * 随机验证码字符
     */
    private static String base = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789";

    /**
     * 随机验证码长度
     */
    private int length = 4;

    /**
     * 验证码字符串
     */
    private String code;

    /**
     * 4位随机验证码
     */
    public RandomCode(){
        this.code = RandomCode.randomString(this.length);
    }

    public RandomCode(int length){
        if(length > 0){
            this.length = length;
        }

        this.code = RandomCode.randomString(this.length);
    }

    /**
     * 生成验证码图片
     * @param width 图片宽度
     * @param height 图片高度
     * @return
     */
    public BufferedImage toImage(int width, int height){
        return RandomCode.toImage(this.code, width, height);
    }

    /**
     * 输出验证码图片，默认图片格式jpeg
     * @param width
     * @param height
     * @param os
     * @throws IOException
     */
    public void write(int width, int height, OutputStream os) throws IOException {
        RandomCode.write(code, width, height, os, "jpeg");
    }

    /**
     * 输出验证码图片
     * @param width
     * @param height
     * @param os
     * @param format 图片格式，支持jpg/jpeg/bmp/gif/png
     * @throws IOException
     */
    public void write(int width, int height, OutputStream os, String format) throws IOException{
        RandomCode.write(code, width, height, os, format);
    }

    public int getLength() {
        return length;
    }

    public String getCode() {
        return code;
    }

    /**
     * 静态方法
     * 生成随机字符串
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String randomString(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    /**
     * 静态方法
     * 输出验证码图片
     * @param code 验证码字符串
     * @param width 图片宽度
     * @param height 图片高度
     * @param os 图片输出流
     * @param format 图片格式，支持jpg/jpeg/bmp/gif/png
     * @throws IOException
     */
    public static void write(String code, int width, int height, OutputStream os, String format) throws IOException{
        BufferedImage image = toImage(code, width, height);
        ImageIO.write(image, format, os);
    }

    /**
     * 静态方法
     * 输出验证码图片，默认图片格式jpeg
     * @param code 验证码字符串
     * @param width 图片宽度
     * @param height 图片高度
     * @param os 图片输出流
     * @throws IOException
     */
    public static void write(String code, int width, int height, OutputStream os) throws IOException{
        write(code, width, height, os, "jpeg");
    }

    /**
     * 静态方法
     * 字符串转成验证码图片
     * @param code 验证码字符串
     * @param width 验证码图片宽度，单位像素
     * @param height 验证码图片高度，单位像素
     * @return
     */
    public static BufferedImage toImage(String code, int width, int height){
        //字体大小
        int fontSize = (int)Math.ceil(height * 0.9);
        if(fontSize < 20){
            fontSize = 20;
        }

        //字体在Y坐标上的位置
        int positionY = (int)Math.ceil(height * 0.8);

        int lenCode = code.length();

        //计算字体宽度
        int fontWidth = width / (lenCode + 2);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();

        //图片背景随机颜色
        g.setColor(randomColor(new Random(), 200, 250));
        g.fillRect(0, 0, width, height);

        //设置字体
        g.setFont(new Font("Times New Roman", Font.BOLD, fontSize));

        //在图片上画纵横交错的线，达到混淆效果
        drawLines(g, width, height);

        //在图片上画验证码
        drawString(g, code, fontWidth, positionY);

        g.dispose();

        return image;
    }

    /**
     * 静态方法
     * 在图片上话位子
     * @param g
     * @param code 验证码字符串
     * @param fontWidth 字体宽度
     * @param positionY 字体Y坐标
     */
    private static void drawString(Graphics g, String code, int fontWidth, int positionY){
        int len = code.length();
        Random random = new Random();
        for(int i = 0; i < len; i++){
            g.setColor(randomColor(random));
            g.drawString(String.valueOf(code.charAt(i)), (i + 1) * fontWidth, positionY);
        }
    }

    private static Color randomColor(Random random){
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }

    private static Color randomColor(Random random, int fc, int bc){
        if(fc > 255){
            fc = 255;
        }

        if(bc > 255){
            bc = 255;
        }

        int diff = bc-fc;
        int r = fc + random.nextInt(diff);
        int g = fc + random.nextInt(diff);
        int b = fc + random.nextInt(diff);
        return new Color(r,g,b);
    }

    /**
     * 静态方法
     * 画纵横交错的线
     * @param g
     * @param width 验证码图片宽度
     * @param height 验证码图片高度
     */
    private static void drawLines(Graphics g, int width, int height){
        Random random = new Random();

        //线的数量
        int count = ((int)(Math.ceil(random.nextDouble() * 100))) + 100;

        for(int i = 0; i < count; i++){
            int fc = 160 + (int)Math.ceil(random.nextDouble() * 40);
            int bc = 200 + (int)Math.ceil(random.nextDouble() * 55);
            g.setColor(randomColor(random, fc, bc));

            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(width / 5);
            int yl = random.nextInt(height / 5);
            g.drawLine(x, y, x + xl, y + yl);
        }
    }
}