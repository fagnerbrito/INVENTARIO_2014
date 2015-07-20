package net.fagner.trf5.inventario2013;

import android.content.Context;
import android.database.Cursor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.ImageView;

public class TimeTrackerAdapter extends CursorAdapter {
	
	public TimeTrackerAdapter (Context context, Cursor cursor) {
		super(context,cursor);
	}
	public void bindView(View view, Context context, Cursor cursor) {
	int [] ImageIds = {R.drawable.monitor1, R.drawable.estabilizador, R.drawable.printer1, R.drawable.telefone, R.drawable.gabinete, R.drawable.nobreak, R.drawable.scanner, R.drawable.fax, R.drawable.cadeira, R.drawable.mesa, R.drawable.mesaapoio, R.drawable.gaveteiro, R.drawable.sofa2lugares, R.drawable.estacaotrabalho, R.drawable.armario, R.drawable.estante, R.drawable.livro, R.drawable.quadro, R.drawable.microondas, R.drawable.seta}; 
	TextView tomboTextView = (TextView) view.findViewById(R.id.tombo_listaview);
    tomboTextView.setText(cursor.getString(4));
    TextView datahoraTextView = (TextView) view.findViewById(R.id.datahora_listaview);
    datahoraTextView.setText(cursor.getString(1));
    TextView descricaoTextView = (TextView) view.findViewById(R.id.descricao_listaview);
    descricaoTextView.setText(cursor.getString(3));
    TextView situacaoTextView = (TextView) view.findViewById(R.id.situacao_textview);
    situacaoTextView.setText(cursor.getString(5));
    ImageView imageviewing= (ImageView) view.findViewById(R.id.icone_listaview);
    imageviewing.setImageResource(ImageIds[cursor.getInt(6)]);
    TextView salaTextView = (TextView) view.findViewById(R.id.sala_listview);
    salaTextView.setText(cursor.getString(7));
    TextView setorTextView = (TextView) view.findViewById(R.id.setor_listview);
    setorTextView.setText(cursor.getString(8));
	}
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.listaview, parent, false);
		return view;
	}
}
