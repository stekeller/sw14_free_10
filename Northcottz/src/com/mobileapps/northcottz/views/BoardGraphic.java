package com.mobileapps.northcottz.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class BoardGraphic extends View {
	Canvas canvas;
	Bitmap bitmap;
	Paint paint;
	int height;
	int width;

	public BoardGraphic(Context context) {
		super(context);

		paint = new Paint();
		paint.setColor(Color.BLACK);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap, 0, 0, paint);
	}

	@Override
	protected void onMeasure(int w, int h) {
		height = View.MeasureSpec.getSize(w);
		width = View.MeasureSpec.getSize(h);
		setMeasuredDimension(width, height);

		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		drawBoard();
	}

	// draw board
	private void drawBoard() {
		// dummy test
		canvas.drawLine(0, 0, width, height, paint);

		// invalidate();
	}

}
