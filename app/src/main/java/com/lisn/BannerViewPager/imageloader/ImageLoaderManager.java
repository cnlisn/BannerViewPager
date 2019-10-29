package com.lisn.BannerViewPager.imageloader;
/**
 * Author: LiShan
 * Time: 2019-10-29
 * Description:
 */
public class ImageLoaderManager {

    private static volatile ImageLoaderManager mImageLoaderManager;

    private IImageLoaderStrategy imageLoader;

    private ImageLoaderManager() {}

    public static ImageLoaderManager getInstance() {
        if(mImageLoaderManager == null) {
            synchronized (ImageLoaderManager.class) {
                if(mImageLoaderManager == null) {
                    mImageLoaderManager = new ImageLoaderManager();
                }
            }
        }
        return mImageLoaderManager;
    }


    public void loadImage(ImageLoaderOptions options) {
        if(imageLoader != null) {
            imageLoader.loadImage(options);
        }
    }

    public void init(IImageLoaderStrategy imageLoader) {
        this.imageLoader = imageLoader;
    }
}
