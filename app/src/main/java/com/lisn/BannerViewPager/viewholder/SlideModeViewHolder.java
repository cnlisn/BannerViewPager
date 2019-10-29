package com.lisn.BannerViewPager.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lisn.BannerViewPager.R;
import com.lisn.bannerview.holder.ViewHolder;

/**
 * Author: LiShan
 * Time: 2019-10-25
 * Description:
 */
public class SlideModeViewHolder implements ViewHolder<Integer> {
    private ImageView mImageView;

    @Override
    public View createView(ViewGroup viewGroup, Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_slide_mode, viewGroup, false);
        mImageView = view.findViewById(R.id.banner_image);
        return view;
    }

    @Override
    public void onBind(Context context, Integer data, int position, int size) {
//        ImageLoaderOptions options = new ImageLoaderOptions.Builder()
//                .into(mImageView)
//                .load(data)
//                .placeHolder(R.drawable.placeholder)
//                .build();
//        ImageLoaderManager.getInstance().loadImage(options);

        mImageView.setImageResource(data);
    }
}
