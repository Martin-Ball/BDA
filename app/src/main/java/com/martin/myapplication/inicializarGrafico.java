package com.martin.myapplication;

import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class inicializarGrafico {

    String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; //ejex


    public void inicializarGraficoLinea(LineChartView lineChart, List<AxisValue> mAxisXValue, int[] ejey) {

        List<PointValue> mPointValues = new ArrayList<PointValue>();


        for (int i = 0; i < mes.length; i++) {
            mAxisXValue.add(new AxisValue(i).setLabel(mes[i]));
        }


        for (int i = 0; i < ejey.length; i++) {
            mPointValues.add(new PointValue(i, ejey[i]));
        }


            Line line = new Line(mPointValues).setColor(Color.parseColor("#662938"));  //color de linea
            List<Line> lines = new ArrayList<Line>();
            line.setShape(ValueShape.CIRCLE);
            line.setCubic(true); //linea continua
            line.setFilled(true); //rellenar area bajo la curva
            line.setHasLabels(true); //datos en curva
            //line.setHasLabelsOnlyForSelected (true); // solo mostrar dato si se toca encima
            line.setHasLines(true);//Ver linea, no solo puntos
            line.setHasPoints(true);//Mostrar punto de informacion
            lines.add(line);
            LineChartData data = new LineChartData();
            data.setLines(lines);

            //ejes
            Axis axisX = new Axis();
            axisX.setHasTiltedLabels(false); //titulos eje x no oblicuos
            axisX.setTextColor(Color.BLACK);  //color de letra
            axisX.setName("Mes"); // nombre de tabla
            axisX.setTextSize(10);// tamaño de fuente
            axisX.setMaxLabelChars(12); //Up to a few X-axis coordinates, which means that your scaling allows the number of data on the X-axis to be 7<=x<=mAxisXValues.length.
            axisX.setValues(mAxisXValue);
            data.setAxisXBottom(axisX);
            axisX.setHasLines(false);


            Axis axisY = new Axis();
            axisY.setName("Compra");
            axisY.setTextSize(10);
            data.setAxisYLeft(axisY);
            axisY.setTextColor(Color.BLACK);

            lineChart.setInteractive(true);
            lineChart.setZoomType(ZoomType.HORIZONTAL);
            lineChart.setMaxZoom((float) 2);
            lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
            lineChart.setLineChartData(data);
            lineChart.setVisibility(View.VISIBLE); //VISIBLE - NO VISIBLE

            //Viewport
            Viewport v = new Viewport(lineChart.getMaximumViewport());
            v.left = 0;
            v.right = 7;
            lineChart.setCurrentViewport(v);

        }

        public void inicializarGraficoBarras(ArrayList<BarEntry> barEntriesArrayList, BarChart barChart, ArrayList<String> lableName)
        {
            BarDataSet barDataSet = new BarDataSet(barEntriesArrayList,"Compras mensual");
            barDataSet.setColors(Color.parseColor("#662938"));

            Description description = new Description();
            description.setText("Meses");
            barChart.setDescription(description);

            BarData barData = new BarData(barDataSet);
            barChart.setData(barData);

            XAxis xAxis = barChart.getXAxis();

            xAxis.setValueFormatter(new IndexAxisValueFormatter(lableName));
            xAxis.setDrawGridLines(false);
            xAxis.setDrawAxisLine(true);
            xAxis.setGranularity(1f);
            xAxis.setLabelCount(lableName.size());
            xAxis.setLabelRotationAngle(270);
            barChart.animateY(1000);
            barChart.invalidate();


            YAxis yAxisRight = barChart.getAxisRight();
            yAxisRight.setEnabled(false); //Mostrar valores derecha
        }
    }