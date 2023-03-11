package model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static model.Constants.RECTA_NUMBER;

public class BufferImage {
    Logger logger = Logger.getLogger(BufferImage.class.getName());
    List<Recta> rectList = new ArrayList<Recta>();
    CyclicList<Feature, Recta> cicl = new CyclicList<>(RECTA_NUMBER*2);
    Rectangle rect = new Rectangle();
    int countBegin = 0;
    int countEnd = 0;
    int count = 0;

    public BufferImage(){
        init();
    }

    private void init (){
        IntStream.range(0, RECTA_NUMBER).forEach(i -> {
            rectList.add(new Recta(500,150, 24, 68, i*360.0/RECTA_NUMBER, 500.0, 350.0));
        });
        cicl.fillNodes(rectList);
       // cicl.print();
    }

    public void draw (Graphics g) {
//        rectList.forEach(r->{
//            r.draw(g);
//            //logger.info("A" + r.name());
//        });
        cicl.forEachNode(r->{
            if(r != null)
            r.draw(g);
            //logger.info("A" + r.name());
        });
    }

    public void mouseClicked (MouseEvent e) {
        cicl.forEachNode(r->{
            if(r != null) {
                rect.setRect(e.getX(), e.getY(), 1.0, 1.0);
                if (r.intersects(rect)) {
                    r.changeColor();
                    return;
                }
            }
        });
    }

    public void pushCounters(){
//        logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//        if(count==RECTA_NUMBER){
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd==RECTA_NUMBER-1 && countBegin==RECTA_NUMBER-1){
//            countEnd=0;
//            count++;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd >= countBegin){
//            if(countEnd==RECTA_NUMBER){
//                countEnd=0;
//            }else {
//                countEnd++;
//            }
//            count++;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd < countBegin){
//            if(countEnd==RECTA_NUMBER){
//                countEnd=0;
//            }else {
//                countEnd++;
//            }
//            count++;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
    }
    public void push () {
        cicl.push(new Feature());
//        pushCounters();
//        if(count==0){
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                rectList.get(i).setColor(Color.RED);
//            });
//        }else if(count==RECTA_NUMBER){
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                rectList.get(i).setColor(Color.MAGENTA);
//            });
//        }else {
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                logger.info("i = " + i);
//                if(countEnd >= countBegin) {
//                    if (i >= countBegin && i < countEnd) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    } else if (i > countEnd) {
//                        rectList.get(i).setColor(Color.RED);
//                    } else if (i <= countBegin) {
//                        rectList.get(i).setColor(Color.RED);
//                    }
//                }
//                if(countEnd < countBegin){
//                    if (i > countEnd && i <= countBegin) {
//                        rectList.get(i).setColor(Color.RED);
//                    } else if (i > countEnd) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    } else if (i <= countBegin) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    }
//                }
//            });
//        }
    }

    public void popCounters(){
//        logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//        if(count==0){
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd==RECTA_NUMBER-1 && countBegin==RECTA_NUMBER-1){
//            countBegin = 0;
//            count--;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd >= countBegin){
//            if(countBegin==RECTA_NUMBER-1){
//                countBegin=0;
//            }else {
//                countBegin++;
//            }
//            count--;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
//        if(countEnd < countBegin){
//            if(countBegin==RECTA_NUMBER-1){
//                countBegin=0;
//            }else {
//                countBegin++;
//            }
//            count--;
//            logger.info("countBegin = " + countBegin + ", CountEnd = " + countEnd + ", count = " + count);
//            return;
//        }
    }
    public void pop () {
        cicl.pop();
//        popCounters();
//        if(count==0){
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                rectList.get(i).setColor(Color.RED);
//            });
//        }else if(count==RECTA_NUMBER){
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                rectList.get(i).setColor(Color.MAGENTA);
//            });
//        }else {
//            IntStream.range(0, RECTA_NUMBER).forEach(i -> {
//                if(countEnd >= countBegin) {
//                    if (i >= countBegin && i < countEnd) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    } else if (i > countEnd) {
//                        rectList.get(i).setColor(Color.RED);
//                    } else if (i <= countBegin) {
//                        rectList.get(i).setColor(Color.RED);
//                    }
//                }
//                if(countEnd < countBegin){
//                    if (i > countEnd && i <= countBegin) {
//                        rectList.get(i).setColor(Color.RED);
//                    } else if (i > countEnd) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    } else if (i <= countBegin) {
//                        rectList.get(i).setColor(Color.MAGENTA);
//                    }
//                }
//            });
//        }
    }
}
