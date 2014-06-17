package com.mobileapps.northcottz.views;

import com.mobileapps.northcottz.GameLogic;
import com.mobileapps.northcottz.GameLogic.Field;
import com.mobileapps.northcottz.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class BoardGraphic extends View {
	private GameLogic gamelogic;
	private Canvas canvas;
	private Bitmap bitmap;
	private Paint paint;
	private int height;
	private int width;
	private float gap;
	private float cell_size;

	private boolean fingerOnScreen;
	private Field touchedField;

	private static int rows = 3;
	private static int cols = 6;

	private Bitmap andro;
	private Bitmap tux;

	public enum player {
		EMPTY, ANDRO, TUX
	}

	private player activePlayer;

	public BoardGraphic(Context context) {
		super(context);

		paint = new Paint();
		paint.setColor(Color.BLACK);
		changeTurn();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap, 0, 0, paint);
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				if (gamelogic.getField(x, y).getOnField() == player.ANDRO)
					canvas.drawBitmap(andro, null, gamelogic.getField(x, y)
							.getFieldRect(), null);
				else if (gamelogic.getField(x, y).getOnField() == player.TUX)
					canvas.drawBitmap(tux, null, gamelogic.getField(x, y)
							.getFieldRect(), null);
			}
		}
	}

	@Override
	protected void onMeasure(int w, int h) {
		height = View.MeasureSpec.getSize(h);
		width = View.MeasureSpec.getSize(w);
		setMeasuredDimension(width, height);

		gamelogic = new GameLogic(rows, cols, gap, cell_size);

		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);

		andro = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		tux = BitmapFactory.decodeResource(getResources(), R.drawable.tux);

		drawBoard();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		int X = (int) event.getX();
		int Y = (int) event.getY();

		switch (eventaction) {
		case MotionEvent.ACTION_DOWN:
			touchedField = gamelogic.getFieldOnPos(X, Y);
			if (touchedField.getOnField() != activePlayer) {
				Toast.makeText(getContext(), "not your player",
						Toast.LENGTH_SHORT).show();
				break;
			}
			fingerOnScreen = true;
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			if (fingerOnScreen && (touchedField != null)) {
				if (gamelogic.makeMove(X, Y, touchedField, activePlayer)) {
					changeTurn();
					isGameOver();
				} else
					Toast.makeText(getContext(), "That's not a legal move", 1)
							.show();
			}

			fingerOnScreen = false;

			break;

		default:
			break;
		}

		invalidate();

		return true;
	}

	private void drawBoard() {

		gap = width / 22;
		cell_size = (width - 2 * gap) / cols;

		for (int i = 0; i <= rows; i++) {
			canvas.drawLine(gap, gap + i * cell_size, width - gap, gap + i
					* cell_size, paint);
		}
		for (int i = 0; i <= cols; i++) {
			canvas.drawLine(gap + i * cell_size, gap, gap + i * cell_size, gap
					+ rows * cell_size, paint);
		}

	}

	private void changeTurn() {
		if (activePlayer == player.TUX)
			activePlayer = player.ANDRO;
		else
			activePlayer = player.TUX;
		Toast.makeText(getContext(),
				"It's your turn " + activePlayer.toString(), 1).show();
	}

	private void isGameOver() {
		if (gamelogic.isGameOver(activePlayer)) {
			Toast.makeText(getContext(),
					"You lost, " + activePlayer.toString(), 1).show();
		}
	}

	public float getGap() {
		return gap;
	}

	public void setGap(float gap) {
		this.gap = gap;
	}

	public float getCell_size() {
		return cell_size;
	}

	public void setCell_size(float cell_size) {
		this.cell_size = cell_size;
	}

}
