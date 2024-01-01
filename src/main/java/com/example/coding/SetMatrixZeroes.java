package com.example.coding;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        Boolean isTopRowZero = false, isFirstColumnZero = false;

        for(int j=0;j<matrix[0].length; j++) {
        	if(matrix[0][j]==0) {
        		isTopRowZero = true;
                break;
        	}
        }
        
        for(int i=0; i<matrix.length; i++) {
        	if(matrix[i][0]==0) {
                isFirstColumnZero = true;
                break;
            }
        }

        for(int i=1; i<matrix.length; i++) {
        	for(int j=1; j<matrix[i].length; j++) {
        		if(matrix[i][j]==0) {
        			matrix[0][j]=0;
        			matrix[i][0]=0;
        		}
        	}
        }
        
        for(int j=1;j<matrix[0].length; j++) {
        	if(matrix[0][j]==0) {
        		for(int i=1; i<matrix.length; i++) {
        			matrix[i][j]=0;
        		}
        	}
        }
        
        for(int i=1; i<matrix.length; i++) {
        	if(matrix[i][0]==0) {
        		for(int j=1; j<matrix[i].length; j++) {
        			matrix[i][j]=0;
        		}
        	}
        }
        
        if(isTopRowZero) {
            for(int j=0;j<matrix[0].length; j++) {
            	matrix[0][j]=0;
            }
        }
        
        if(isFirstColumnZero) {
            for(int i=0; i<matrix.length; i++) {
            	matrix[i][0]=0;
            }
        }
        
    }

}
