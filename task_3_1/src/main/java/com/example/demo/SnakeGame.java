package com.example.demo;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class SnakeGame extends Application {
    private static final int SCORE_FOR_WIN = 10;
    private final int DOWN = 0;
    private final int LEFT = 1;
    private final int UP = 2;
    private final int RIGHT = 3;

    private final int HORIZONTAL_SIZE;
    private final int VERTICAL_SIZE;
    private final int ROWS;
    private final int COLUMNS;
    private final int POINT_SIZE;
    private final int MAX_FOOD;
    private final int MAX_WALLS;
    private boolean flag;
    private GameField gameField;
    private FoodGenerator foodGenerator;
    private WallsGenerator wallsGenerator;
    private Snake snake;
    private Graphics graphics;
    private Timeline timeline;
    private int direction;
    private int score;

    public static void main(String[] args) {
        launch();
    }
    public SnakeGame(){
        flag = false;
        HORIZONTAL_SIZE = 720;
        VERTICAL_SIZE = 720;
        ROWS = 20;
        COLUMNS = 20;
        POINT_SIZE = 720/20;
        MAX_WALLS = 10;
        MAX_FOOD = 10;
        score = 0;
    }

    @Override
    public void start(Stage stage) {
        direction = RIGHT;
        gameField = new GameField(HORIZONTAL_SIZE, VERTICAL_SIZE, COLUMNS, ROWS, POINT_SIZE);
        foodGenerator = new FoodGenerator(gameField, MAX_FOOD);
        wallsGenerator = new WallsGenerator(gameField, MAX_WALLS);
        snake = new Snake(gameField, foodGenerator, wallsGenerator);
        graphics = new Graphics(gameField);
        stage.setTitle("PYTHON");
        Group root = new Group();
        Canvas canvas = new Canvas(HORIZONTAL_SIZE, VERTICAL_SIZE);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();

            if (keyCode == KeyCode.UP) {
                if (direction != DOWN || snake.getPython().size()==1) {
                    direction = UP;
                }

            } else if (keyCode == KeyCode.LEFT) {
                if (direction != RIGHT|| snake.getPython().size()==1) {
                    direction = LEFT;
                }
            } else if (keyCode == KeyCode.DOWN) {
                if (direction != UP|| snake.getPython().size()==1) {
                    direction = DOWN;
                }
            } else if (keyCode == KeyCode.RIGHT) {
                if (direction != LEFT|| snake.getPython().size()==1) {
                    direction = RIGHT;
                }
            }else if(keyCode == KeyCode.SPACE){
                if(flag){
                    restart(graphicsContext);
                }
            }
        });

        wallsGenerator.generateWalls(snake);
        foodGenerator.generateFood(wallsGenerator, snake);
        snake.collision();
        timeline = new Timeline(new KeyFrame(Duration.millis(170), e -> crawling(graphicsContext)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void restart(GraphicsContext graphicsContext) {

            timeline.play();
            wallsGenerator.remove();
            foodGenerator.remove();
            snake.remove();
            direction = RIGHT;
            wallsGenerator.generateWalls(snake);
            foodGenerator.generateFood(wallsGenerator, snake);
            score = snake.getScore();

    }


    private void crawling(GraphicsContext graphicsContext) {
        if (snake.collision()) {
            flag = true;
            timeline.stop();
            graphics.drawCollision(graphicsContext, snake.getCollisionPoint());
            graphics.drawGameOver(graphicsContext, score);
            return;
        }
        if (score == SCORE_FOR_WIN) {
            flag = true;
            timeline.stop();
            graphics.drawWin(graphicsContext);
            return;
        }
        graphics.drawBackGround(graphicsContext);
        graphics.drawWalls(graphicsContext, wallsGenerator.getWalls());
        graphics.drawPython(graphicsContext, snake.getPython());
        snake.devourFood();
        graphics.drawFood(graphicsContext, foodGenerator.getFood());
        score = snake.getScore();
        graphics.drawScore(graphicsContext, score);
        if (snake.getPython().size() > 1) {
            Point crawling = snake.getPython().get(snake.getPython().size() - 1);
            crawling.x = snake.getPythonHead().x;
            crawling.y = snake.getPythonHead().y;
            snake.getPython().add(1, crawling);
            snake.getPython().remove(snake.getPython().size() - 1);
        }

        if (direction == RIGHT) {
            snake.crawlRight();
        } else if (direction == DOWN) {
            snake.crawlDown();
        } else if (direction == LEFT) {
            snake.crawlLeft();
        } else {
            snake.crawlUp();
        }
    }

}