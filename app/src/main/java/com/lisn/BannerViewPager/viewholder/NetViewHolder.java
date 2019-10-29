package com.lisn.BannerViewPager.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lisn.BannerViewPager.R;
import com.lisn.BannerViewPager.imageloader.ImageLoaderManager;
import com.lisn.BannerViewPager.imageloader.ImageLoaderOptions;
import com.lisn.BannerViewPager.net.BannerData;
import com.lisn.bannerview.holder.ViewHolder;

/**
 * Author: LiShan
 * Time: 2019-10-25
 * Description:
 */
public class NetViewHolder implements ViewHolder<BannerData> {
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    public View createView(ViewGroup viewGroup, Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_net, viewGroup, false);
        mImageView = view.findViewById(R.id.banner_image);
        mTextView = view.findViewById(R.id.tv_describe);
        return view;
    }

    @Override
    public void onBind(Context context, BannerData data, int position, int size) {
        ImageLoaderOptions options = new ImageLoaderOptions.Builder().into(mImageView).load(data.getImagePath()).placeHolder(R.drawable.placeholder).build();
        ImageLoaderManager.getInstance().loadImage(options);
        mTextView.setText(data.getTitle());
    }
}
