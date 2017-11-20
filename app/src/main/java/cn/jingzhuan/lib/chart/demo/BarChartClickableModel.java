package cn.jingzhuan.lib.chart.demo;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.widget.Toast;
import cn.jingzhuan.lib.chart.Chart;
import cn.jingzhuan.lib.chart.data.BarDataSet;
import cn.jingzhuan.lib.chart.data.BarValue;
import cn.jingzhuan.lib.chart.demo.databinding.LayoutBarChartBinding;
import cn.jingzhuan.lib.chart.demo.databinding.LayoutBarChartClickableItemBinding;
import cn.jingzhuan.lib.chart.event.OnEntryClickListener;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyModelClass;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglua on 11/20/17.
 */

@EpoxyModelClass(layout = R.layout.layout_bar_chart_clickable_item)
public abstract class BarChartClickableModel extends DataBindingEpoxyModel {

  private BarDataSet barDataSet;
  private List<BarValue> barValueList = new ArrayList<>();

  public BarChartClickableModel() {

    barValueList.add(new BarValue(11));
    barValueList.add(new BarValue(4));
    barValueList.add(new BarValue(6));
    barValueList.add(new BarValue(13));
    barValueList.add(new BarValue(8));
    barValueList.add(new BarValue(9));
    barValueList.add(new BarValue(12));

    barDataSet = new BarDataSet(barValueList);
    barDataSet.setAutoBarWidth(true);
  }

  @Override
  protected void setDataBindingVariables(final ViewDataBinding binding) {
    if (binding instanceof LayoutBarChartClickableItemBinding) {

      LayoutBarChartClickableItemBinding barBinding = (LayoutBarChartClickableItemBinding) binding;

      barBinding.barChart.setDataSet(barDataSet);
      barBinding.barChart.getAxisRight().setLabelTextColor(Color.BLACK);
      barBinding.barChart.setOnEntryClickListener(new OnEntryClickListener() {
        @Override public void onEntryClick(Chart chart, int position) {
          Toast.makeText(binding.getRoot().getContext(),
              "value = " + barValueList.get(position).getValues()[0],
              Toast.LENGTH_SHORT).show();
        }
      });
    }
  }
}
