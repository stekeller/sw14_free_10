package com.mobileapps.northcottz;

import java.util.Iterator;
import java.util.Random;

import com.mobileapps.northcottz.views.BoardGraphic.player;

import android.graphics.RectF;
import android.widget.Toast;

public class GameLogic {

	private Row[] rows;
	private int numCols;

	public GameLogic(int numRows, int numCols, float gap, float cell_size) {
		this.numCols = numCols;
		this.rows = new Row[numRows];
		for (int i = 0; i < numRows; i++) {
			this.rows[i] = new Row(numCols);
		}
		for (int y = 0; y < numRows; y++) {
			for (int x = 0; x < numCols; x++) {
				getField(x, y).setFieldRect(
						new RectF(gap + x * cell_size, gap + y * cell_size, gap
								+ (x + 1) * cell_size, gap + (y + 1)
								* cell_size));
				getField(x, y).setInCol(x);
				getField(x, y).setInRow(y);
			}
		}
		
		getField(0, 0).setOnField(player.ANDRO);
		getField(0, 1).setOnField(player.ANDRO);
		getField(0, 2).setOnField(player.ANDRO);
		getField(1, 0).setOnField(player.TUX);
		getField(1, 1).setOnField(player.TUX);
		getField(2, 2).setOnField(player.TUX);
	}
	
	private void initializePositions(){
		Random r = new Random();
		
		for (Row row : rows) {
			// TODO set random p1 and random p2
		}
	}

	public boolean makeMove(int x, int y, Field start, player activePlayer) {
		Field end = getFieldOnPos(x, y);
		if (end != null) {
			if (isLegalMove(start, end)) {
				start.setOnField(player.EMPTY);
				end.setOnField(activePlayer);
				return true;
			}
		}
		return false;
	}

	public Field getFieldOnPos(int x, int y) {
		for (Row row : rows) {
			for (Field field : row.getFields()) {
				if (field.getFieldRect().contains(x, y))
					return field;
			}
		}

		return null;
	}

	private boolean isLegalMove(Field start, Field end) {
		if (start.inCol == end.inCol)
			return false;
		if (end.getOnField() != player.EMPTY)
			return false;
		if (end.inRow != start.inRow)
			return false;
		return true;
	}
	
	public boolean isGameOver(player activePlayer){
		int lockedCounter = 0;
		for (Row row : rows) {
			Field[] fields = row.getFields();
			if((fields[0].getOnField() == activePlayer)&& fields[1].getOnField() != player.EMPTY)
				lockedCounter++;
			else if((fields[fields.length-1].getOnField() == activePlayer)&& fields[fields.length-2].getOnField() != player.EMPTY)
				lockedCounter++;
		}
		if (lockedCounter==rows.length)
			return true;
		else
			return false;
	}

	public Field getField(int x, int y) {
		return this.rows[y].getFields()[x];
	}

	public class Row {
		private Field[] fields;

		public Row(int cols) {
			fields = new Field[cols];
			for (int i = 0; i < cols; i++) {
				fields[i] = new Field();
			}
		}

		public Field[] getFields() {
			return fields;
		}

		public void setFields(Field[] fields) {
			this.fields = fields;
		}
	}

	public class Field {
		private player onField;
		private RectF fieldRect;
		private int inRow;
		private int inCol;

		public Field() {
			onField = player.EMPTY;
		}

		public player getOnField() {
			return onField;
		}

		public void setOnField(player filled) {
			this.onField = filled;
		}

		public RectF getFieldRect() {
			return fieldRect;
		}

		public void setFieldRect(RectF rectF) {
			this.fieldRect = rectF;
		}

		public int getInRow() {
			return inRow;
		}

		public void setInRow(int inRow) {
			this.inRow = inRow;
		}

		public int getInCol() {
			return inCol;
		}

		public void setInCol(int inCol) {
			this.inCol = inCol;
		}

	}

}
