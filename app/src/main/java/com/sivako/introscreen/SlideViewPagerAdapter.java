package com.sivako.introscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context context;

    public SlideViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);

        ImageView logo = view.findViewById(R.id.logo);
        ImageView indicatorSelector1 = view.findViewById(R.id.indicatorSelector1);
        ImageView indicatorSelector2 = view.findViewById(R.id.indicatorSelector2);
        ImageView indicatorSelector3 = view.findViewById(R.id.indicatorSelector3);

        ImageView next = view.findViewById(R.id.next);
        ImageView back = view.findViewById(R.id.back);

        TextView title = view.findViewById(R.id.titleText);
        TextView desc = view.findViewById(R.id.desc);

        switch (position) {
            case 0:
                logo.setImageResource(R.drawable.dividebuy_nohidden_fees);
                indicatorSelector1.setImageResource(R.drawable.selected);
                indicatorSelector2.setImageResource(R.drawable.unselected);
                indicatorSelector3.setImageResource(R.drawable.unselected);

                title.setText("There\'s no APR to pay");
                desc.setText("Every order is entirely interest free, no matter the basket value or term length.");

                back.setVisibility(View.GONE);
                break;
            case 1:
                logo.setImageResource(R.drawable.dividebuy_spreadthe_cost);
                indicatorSelector1.setImageResource(R.drawable.unselected);
                indicatorSelector2.setImageResource(R.drawable.unselected);
                indicatorSelector3.setImageResource(R.drawable.selected);

                title.setText("Spread the cost by paying in monthly instalments");
                desc.setText("Spread the cost of your order easily in monthly instalments between 2 and 12 months.");

                break;
            case 2:
                logo.setImageResource(R.drawable.dividebuy_finance_60sec);
                indicatorSelector1.setImageResource(R.drawable.unselected);
                indicatorSelector2.setImageResource(R.drawable.selected);
                indicatorSelector3.setImageResource(R.drawable.unselected);

                title.setText("Quick & easy application");
                desc.setText("Instant decision and a 60 second application, you can spread the cost of your order in a few simple steps.");

                next.setVisibility(View.GONE);
                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView( (View) object);
    }
}
