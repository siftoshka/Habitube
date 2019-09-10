package az.amorphist.habitube.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import az.amorphist.habitube.R;

import static az.amorphist.habitube.Constants.SYSTEM.IMAGE_URL;

public class GlideLoader {

    public static void load(View view, String url, ImageView into) {
        Glide.with(view)
                .load(IMAGE_URL + url)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.ic_poster_name)
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(into);
    }

    public static void load(Context context, String url, ImageView into) {
        Glide.with(context)
                .load(IMAGE_URL + url)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.ic_poster_name)
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(into);
    }

    public static void loadBackground(Context context, String url, ImageView into) {
        Glide.with(context)
                .load(IMAGE_URL + url)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .error(R.drawable.ic_poster_name)
                .placeholder(R.drawable.progress_animation)
                .into(into);
    }
}