package com.henryxi.awt.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class MosaicClient {

    public static void main(String[] args) throws Exception {
//        mosaic(100);
        zoom(100,100);
    }

    public static boolean mosaic(int size) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\1563271653865.png");
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        BufferedImage spinImage = new BufferedImage(bi.getWidth(),
                bi.getHeight(), bi.TYPE_INT_RGB);
        if (bi.getWidth() < size || bi.getHeight() < size || size <= 0) { // 马赛克格尺寸太大或太小
            return false;
        }

        int xcount = 0; // 方向绘制个数
        int ycount = 0; // y方向绘制个数
        if (bi.getWidth() % size == 0) {
            xcount = bi.getWidth() / size;
        } else {
            xcount = bi.getWidth() / size + 1;
        }
        if (bi.getHeight() % size == 0) {
            ycount = bi.getHeight() / size;
        } else {
            ycount = bi.getHeight() / size + 1;
        }
        int x = 0;   //坐标
        int y = 0;
        // 绘制马赛克(绘制矩形并填充颜色)
        Graphics gs = spinImage.getGraphics();
        for (int i = 0; i < xcount; i++) {
            for (int j = 0; j < ycount; j++) {
                //马赛克矩形格大小
                int mwidth = size;
                int mheight = size;
                if(i==xcount-1){   //横向最后一个比较特殊，可能不够一个size
                    mwidth = bi.getWidth()-x;
                }
                if(j == ycount-1){  //同理
                    mheight =bi.getHeight()-y;
                }
                // 矩形颜色取中心像素点RGB值
                int centerX = x;
                int centerY = y;
                if (mwidth % 2 == 0) {
                    centerX += mwidth / 2;
                } else {
                    centerX += (mwidth - 1) / 2;
                }
                if (mheight % 2 == 0) {
                    centerY += mheight / 2;
                } else {
                    centerY += (mheight - 1) / 2;
                }
                Color color = new Color(bi.getRGB(centerX, centerY));
                gs.setColor(color);
                gs.fillRect(x, y, mwidth, mheight);
                y = y + size;// 计算下一个矩形的y坐标
            }
            y = 0;// 还原y坐标
            x = x + size;// 计算x坐标
        }
        gs.dispose();
        File sf = new File("C:\\Users\\Administrator\\Desktop", "test.jpg");
        ImageIO.write(spinImage, "jpg", sf); // 保存图片
        return true;
    }

    public static void zoom(int width, int height) throws Exception {
        double sx = 0.0;
        double sy = 0.0;

        File file = new File("C:\\Users\\Administrator\\Desktop\\1563271653865.png");
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        // 计算x轴y轴缩放比例--如需等比例缩放，在调用之前确保参数width和height是等比例变化的
        sx = (double) width / bi.getWidth();
        sy = (double) height / bi.getHeight();

        AffineTransformOp op = new AffineTransformOp(
                AffineTransform.getScaleInstance(sx, sy), null);
        File sf = new File("C:\\Users\\Administrator\\Desktop", "test.jpg");
        Image zoomImage = op.filter(bi, null);
        try {
            ImageIO.write((BufferedImage) zoomImage, "jpg", sf); // 保存图片
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
