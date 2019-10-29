package com.lisn.bannerview.holder;

/**
 * Author: LiShan
 * Time: 2019-10-25  16:54
 * Description:
 */

public interface HolderCreator<VH extends ViewHolder> {
    /**
     * 创建ViewHolder
     */
    VH createViewHolder();
}
