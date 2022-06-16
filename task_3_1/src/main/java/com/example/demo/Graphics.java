package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.List;

public class Graphics {
    private static final int SCORE_FOR_WIN = 10;
    private GameField gameField;

    public Graphics(GameField gameField) {
        this.gameField = gameField;
    }

    public void drawBackGround(GraphicsContext graphicsContext) {
        for (int i = 0; i < gameField.getROWS(); i++) {
            for (int j = 0; j < gameField.getCOLUMNS(); j++) {
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillRect(i * gameField.getPOINT_SIZE(), j * gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE());
            }
        }
    }

    public void drawFood(GraphicsContext graphicsContext, List<Point> food) {
        graphicsContext.setFill(Color.web("ff0000"));
        for (Point point : food) {
            graphicsContext.fillRoundRect(point.getX() * gameField.getPOINT_SIZE(), point.getY() * gameField.getPOINT_SIZE(),
                    gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE(), 45, 45);
        }

    }

    public void drawPython(GraphicsContext graphicsContext, List<Point> python) {
        graphicsContext.setFill(Color.YELLOW);
        for (Point point : python) {
            graphicsContext.fillRoundRect(point.getX() * gameField.getPOINT_SIZE(),
                    point.getY() * gameField.getPOINT_SIZE(),
                    gameField.getPOINT_SIZE() - 1,
                    gameField.getPOINT_SIZE() - 1,
                    25, 25);
        }
    }

    public void drawWalls(GraphicsContext graphicsContext, List<Point> walls) {
        graphicsContext.setFill(Color.LIGHTSTEELBLUE);
        for (Point point : walls) {
            graphicsContext.fillRect(point.getX() * gameField.getPOINT_SIZE(), point.getY() * gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE());
        }
    }

    public void drawCollision(GraphicsContext graphicsContext, Point collisionPoint) {
        graphicsContext.setFill(Color.web("32CD32"));
        graphicsContext.fillRoundRect(collisionPoint.getX() * gameField.getPOINT_SIZE(), collisionPoint.getY() * gameField.getPOINT_SIZE(),
                gameField.getPOINT_SIZE(), gameField.getPOINT_SIZE(), 25, 25);
    }


    public void drawScore(GraphicsContext graphicsContext, int score) {
        graphicsContext.setFill(Color.RED);
        graphicsContext.setFont(new Font("Digital-7", 35));
        graphicsContext.fillText("ОЧКИ: " + score , 10, 35);
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillText("ОЧКИ: " + score , 9.02, 34.03);
    }

    public void drawGameOver(GraphicsContext graphicsContext, int score) {
        drawBackGround(graphicsContext);
        graphicsContext.setFill(Color.RED);

        graphicsContext.setFont(new Font("Digital-7", 50));
        graphicsContext.fillText("ИГРА ОКОНЧЕНА" + "\n" + "ОЧКИ: " + score + "\n" + "ОЧКОВ ДО ПОБЕДЫ: " + SCORE_FOR_WIN
                ,gameField.getWIDTH() / 6.6, gameField.getHEIGHT() / 3.0);
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillText("ИГРА ОКОНЧЕНА" + "\n" + "ОЧКИ: " + score + "\n" + "ОЧКОВ ДО ПОБЕДЫ: " + SCORE_FOR_WIN
                ,gameField.getWIDTH() / 6.66, gameField.getHEIGHT() / 3.05);
    }

    public void drawWin(GraphicsContext graphicsContext) {

            drawBackGround(graphicsContext);
            graphicsContext.setFill(Color.RED);
            graphicsContext.setFont(new Font("Regular", 50));
            graphicsContext.fillText("ТЫ ПОБЕДИЛ", gameField.getWIDTH() / 4.5, gameField.getHEIGHT() / 2.5);
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillText("ТЫ ПОБЕДИЛ", gameField.getWIDTH() / 4.55, gameField.getHEIGHT() / 2.55);
        }
    }
