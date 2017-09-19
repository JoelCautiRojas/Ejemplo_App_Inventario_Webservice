package com.example.joel_64.almacenamientoremotoestandar_appandroid;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter{
    private String BASE_URL;
    private String DIR_IMG;
    private LayoutInflater inflador;
    private ArrayList nombres_list;
    private ArrayList codigos_list;
    private ArrayList categorias_list;
    private ArrayList descripciones_list;
    private ArrayList precios_list;
    private ArrayList stocks_list;
    private ArrayList imagenes_list;

    public Adapter(Context contexto, ArrayList nombres, ArrayList codigos, ArrayList categorias, ArrayList descripciones, ArrayList precios, ArrayList stocks, ArrayList imagenes, String BaseUrl, String DirImg){
        this.nombres_list = nombres;
        this.codigos_list = codigos;
        this.categorias_list = categorias;
        this.descripciones_list = descripciones;
        this.precios_list = precios;
        this.stocks_list = stocks;
        this.imagenes_list = imagenes;
        this.BASE_URL = BaseUrl;
        this.DIR_IMG = DirImg;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return nombres_list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = view;
        ViewHolder holder;
        if(item == null)
        {
            item = inflador.inflate(R.layout.item_list_activity_main,null);
            holder = new ViewHolder();
            holder.nombre = (TextView) item.findViewById(R.id.nombre_item);
            holder.categoria = (TextView) item.findViewById(R.id.categoria_item);
            holder.descripcion = (TextView) item.findViewById(R.id.descripcion_item);
            holder.precio = (TextView) item.findViewById(R.id.precio_item);
            holder.stock = (TextView) item.findViewById(R.id.stock_item);
            holder.imagen = (SmartImageView) item.findViewById(R.id.imagen_item);
            item.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) item.getTag();
        }
        //Establecer Datos
        holder.nombre.setText(nombres_list.get(i).toString());
        holder.categoria.setText(categorias_list.get(i).toString());
        holder.descripcion.setText(descripciones_list.get(i).toString() + "\r\n\nCodigo: " +codigos_list.get(i).toString());
        holder.precio.setText("Precio: S/. " + precios_list.get(i).toString());
        holder.stock.setText("Stock: " + stocks_list.get(i).toString());
        Rect rectangulo = new Rect(holder.imagen.getLeft(),holder.imagen.getTop(),holder.imagen.getRight(),holder.imagen.getBottom());
        holder.imagen.setImageUrl(BASE_URL + DIR_IMG + imagenes_list.get(i).toString(),rectangulo);
        return item;
    }

    static class ViewHolder{
        TextView nombre;
        TextView categoria;
        TextView descripcion;
        TextView precio;
        TextView stock;
        SmartImageView imagen;
    }
}