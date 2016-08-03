package com.henryxi.core.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawBackground {
    public static void main(String[] args) throws IOException {
        String desktopPath = System.getProperty("user.home") + "/Desktop/background.png";
        BufferedImage img = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setPaint(new Color(58, 110, 165));
        graphics.fillRect(0, 0, img.getWidth(), img.getHeight());
        Font font = new Font("宋体", Font.PLAIN, 12);
        graphics.setFont(font);
        String s = "1、商城首页增加轮播推广banner位，可链接至店铺主页、商品详情页、标签商品聚合页；\n" +
                "2、标签：为商品添加标签，商城首页展示热门标签，有单标签的商品聚合页；商品详情页增加多个标签的展示；\n" +
                "3、商城首页增加搜索商品入口（点击进入搜索推荐、搜索结果）；\n" +
                "4、买家付款72小时内未发货自动取消订单;增加3个消息类型；\n" +
                "5、商城首页推荐位功能（包含后台配置对应推荐位功能）；\n" +
                "6、卖家和店主通过线上查看每个账期的收益；";
        graphics.setPaint(Color.white);
        drawString(graphics, s, 200, 200);
        graphics.dispose();
        File f = new File(desktopPath);
        ImageIO.write(img, "PNG", f);
    }

    private static void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
}
