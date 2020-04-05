package com.aote.recursion;

/**
 * 迷宫
 */
public class Maze {

    public static void main(String[] args) {
        // 二维数组模拟迷宫
        int[][] maze = new int [8][7];
        // 使用1表示墙，上下全为1
        for(int i=0;i<7;i++){
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for(int i=0;i<8;i++){
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        // 设置挡板
        maze[3][1]=1;
        maze[2][2]=1;
        maze[3][2]=1;

        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
        setWay2(maze,1,1);

        System.out.println("小球走过并标识的地图");
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     * maze表示迷宫。i、j表示从哪里开始，maze[6][5]表示结束
     * 约定：当maze[i][j]为0表示该点没有走过，1表示墙，2表示通路，3表示该路走过，但是不通
     * 走迷宫时需要一个策略，先走下->右->上->左，如果该点不通，再回溯
     * @param maze
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路就返回true，否则返回false
     */
    public static boolean setWay(int[][] maze,int i,int j){

        if(maze[6][5]==2){
            return true;
        } else {
            // 如果当前点没有走过
            if(maze[i][j]==0) {
                // 按照策略走
                maze[i][j] = 2; // 假定该点可以走过
                if(setWay(maze,i+1,j)){// 向下走
                    return true;
                } else if (setWay(maze,i,j+1)){// 向右走
                    return true;
                } else if (setWay(maze,i-1,j)){// 向上走
                    return true;
                } else if (setWay(maze,i,j-1)){// 向左走
                    return true;
                } else {
                    // 说明该点是死路
                    maze[i][j] = 3;
                }
            } else { // 如果maze[i][j] != 0，可能是1，2，3
                return false;
            }
            return false;
        }
    }

    /**
     * 修改找路策略 上->右->下->左
     * @param maze
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay2(int[][] maze,int i,int j){

        if(maze[6][5]==2){
            return true;
        } else {
            // 如果当前点没有走过
            if(maze[i][j]==0) {
                // 按照策略走
                maze[i][j] = 2; // 假定该点可以走过
                if(setWay2(maze,i-1,j)){// 向下走
                    return true;
                } else if (setWay2(maze,i,j+1)){// 向右走
                    return true;
                } else if (setWay2(maze,i+1,j)){// 向上走
                    return true;
                } else if (setWay2(maze,i,j-1)){// 向左走
                    return true;
                } else {
                    // 说明该点是死路
                    maze[i][j] = 3;
                }
            } else { // 如果maze[i][j] != 0，可能是1，2，3
                return false;
            }
            return false;
        }
    }

}
