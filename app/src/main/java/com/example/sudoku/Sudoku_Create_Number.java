package com.example.sudoku;
import java.util.*;

public class Sudoku_Create_Number {
	public static int Hard = 30; ///设置数独的难度，即每个格子上面有无数字的概率。
	public void setHard(int hard) {
		Hard = hard;
	}
	Random random = new Random();///取随机数
	public static int num[][] = new int[11][11];
	private int visx[][] = new int[11][11];
	private int visy[][] = new int[11][11];
	private int visz[][] = new int[11][11];
	public int ans[][] = new int[11][11]; 
	private int base[][] = {{0},{0,1,4,3,6,2,8,5,7,9},{0,5,7,2,1,3,9,4,6,8},{0,9,8,6,7,5,4,2,3,1},{0,3,9,1,5,4,2,7,8,6},{0,4,6,8,9,1,7,3,5,2},{0,7,2,5,8,6,3,9,1,4},{0,2,3,7,4,8,1,6,9,5},{0,6,1,9,2,7,5,8,4,3},{0,8,5,4,3,9,6,1,2,7}};///基础数组。
	private Boolean Checkx(int x,int k)///是否能在第x行放入数字k
	{
		if(visx[x][k]==1) ///如果第x行已经有k了，则不能放入。
		{
			return false;
		}
		return true;
	}
	private Boolean Checky(int y,int k)
	{
		if(visy[y][k] == 1)
		{
			return false;
		}
		return true;
	}
	private Boolean Checkz(int x,int y,int k)
	{
		x--;y--;
		int z = 3*(y/3)+(x/3);
		if(visz[z][k]==1)
		{
			return false;
		}
		return true;
	}
	/*
	 * 
	 * 创建实例后用下面这个函数后，然后查看num数组就是数独了。
	 * 
	 */
	public void CreateSudoku() {
		for(int i = 1;i<=9;i++)
		{
			for(int j = 1;j<=9;j++)
			{
				num[i][j] = base[i][j];
			}
		}
		for(int i = 1;i<=15;i++)
		{
			int x = random.nextInt(10);
			int y = random.nextInt(10);
			while(x!=y)
			{
				y = random.nextInt(10);
			}
			int q = random.nextInt(2);
			if(q==0)
			{
				q = random.nextInt(10);
				for(int j = 1;j<=9;j++)
				{
					if(num[q][j] == x || num[q][j] == y)
					{
						for(int k = j+1;k<=9;k++)
						{
							if(num[q][k] == x || num[q][k]==y)
							{
								num[q][j] = num[q][k]^num[q][j];
								num[q][k] = num[q][j]^num[q][k];
								num[q][j] = num[q][j]^num[q][k];
								break;
							}
						}
						break;
					}
				}
			}
			else 
			{
				q = random.nextInt(10);
				for(int j = 1;j<=9;j++)
				{
					if(num[j][q] == x || num[j][q] == y)
					{
						for(int k = j+1;k<=9;k++)
						{
							if(num[k][q] == x || num[k][q]==y)
							{
								num[j][q] = num[k][q]^num[j][q];
								num[k][q] = num[j][q]^num[k][q];
								num[j][q] = num[j][q]^num[k][q];
								break;
							}
						}
						break;
					}
				}
			}
		}
		
		for(int i = 1;i<=9;i++)
		{
			for(int j = 1;j<=9;j++)
			{
				ans[i][j] = num[i][j];
				int q = random.nextInt(100);
				if(q>Hard)
				{
					num[i][j] = 0;
				}
			}
		}
	}
	//传入一个二维数组。判断对不对
	public boolean CheckTrue(int a[][])
	{
		for(int i = 1;i<=9;i++)
		{
			for(int j = 1;j<=9;j++)
			{
				visx[i][j] = 0;
				visy[i][j] = 0;
				visz[i][j] = 0;
			}
		}
		for(int i = 1;i<=9;i++)
		{
			for(int j = 1;j<=9;j++)
			{
				if(Checkx(i, a[i][j]) && Checky(j, a[i][j]) && Checkz(i, j, a[i][j]) && a[i][j]!=0 )
				{
					visx[i][a[i][j]] = 1;
					visy[j][a[i][j]] = 1;
					int x = i,y= j;
					x--;y--;
					int z = 3*(y/3)+(x/3);
					visz[z][a[i][j]] = 1;
					continue;
				}
				else 
				{
					return false;
				}
			}
		}
		return true;
	}

}
