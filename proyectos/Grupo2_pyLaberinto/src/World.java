public class World{
    

    final int row = 0;
	final int column = 0;
	private int actualRow=57;
	private int actualColumn=27;
	Character characters = new Character();
	Position position = new Position();

    public static void showMaze(int torch, int viewport) {
		
	position.setX(actualRow);
	position.setY(actualColumn);
	
        for (row=0; row<maze.length; row = row+1) {
            if ((actualRow+viewport>=row)&&(actualRow-viewport<=row)) {
                System.out.print(Colors.BLOCK);
                for (column=0; column<maze[row].length; column = column+1) {
                    
                    if (row==actualRow && column==actualColumn) {
						characters.choose();
					} else if((actualColumn+viewport>=column)&&(actualColumn-viewport<=column)) {
                        if ((Math.pow(actualRow-row,2)+Math.pow(actualColumn-column,2))<=(Math.pow(torch,2))) {	

                            if (maze[row][column]==Surface.ID_FLOOR){
                                System.out.print(Surface.FLOOR);
                            }	
                            else if (maze[row][column]==Surface.ID_WALL){
                                System.out.print(Surface.WALL);
                            }
                            else if (maze[row][column]==Surface.ID_GRASS){
                                System.out.print(Surface.GRASS);
                            }	
                            else if (maze[row][column]==Surface.ID_WATER){
                                System.out.print(Surface.WATER);
                            }	
                            else if (maze[row][column]==Surface.ID_MEDIUM_GRASS){
                                System.out.print(Surface.MEDIUM_GRASS);
                            }	
                            else if (maze[row][column]==Surface.ID_SAND){
                                System.out.print(Surface.SAND);
                            }
                            else if (maze[row][column]==Surface.ID_TALL_GRASS){
                                System.out.print(Surface.TALL_GRASS);
                            }	
                            else if (maze[row][column]==Surface.ID_HEAVY_WATER){
                                System.out.print(Surface.HEAVY_WATER);
                            }
                            else if (maze[row][column]==Surface.ID_MOUNTAIN){
                                System.out.print(Surface.MOUNTAIN);
                            }
                        } else {
                            System.out.print(Colors.DARKNESS);
                        }
                    }
                }
                System.out.println(Colors.BLOCK);
            }
        }
        System.out.print(Colors.BLOCK);
        for(int i=0;i<=viewport*2;i=i+1){
            System.out.print(Colors.BLOCK);
        }
        System.out.println(Colors.BLOCK);	
    }


}