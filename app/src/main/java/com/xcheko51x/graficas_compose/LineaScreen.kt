package com.xcheko51x.graficas_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer

@Composable
fun LineaScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gráfica de Lineas"
        )

        Lineas()
    }
}

@Composable
fun Lineas() {
    val datos = DatosGraficar.datos

    var points = ArrayList<LineChartData.Point>()

    datos.mapIndexed { index, datos ->
        points.add(
            LineChartData.Point(
                label = datos.label,
                value = datos.value
            )
        )
    }

    var lines = ArrayList<LineChartData>()

    lines.add(
        LineChartData(
            points = points,
            lineDrawer = SolidLineDrawer()
        )
    )

    LineChart(
        modifier = Modifier
            .padding(30.dp, 80.dp)
            .height(300.dp),
        linesChartData = lines
    )
}