package greek.dev.challenge.charities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import greek.dev.challenge.charities.R;
import greek.dev.challenge.charities.model.Wish;

/**
 * Created by nalex on 26/12/2017.
 */

public class WishAdapter extends
        RecyclerView.Adapter<WishAdapter.ViewHolder> {

    private List<Wish> mWishes;
    private Context mContext;

    public WishAdapter(Context context, List<Wish> wishes) {
        mContext = context;
        mWishes = wishes;
    }

    private Context getContext() {
        return mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView wishTextView;
        public TextView authorTextView;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            wishTextView = (TextView) itemView.findViewById(R.id.wish_item_view);
            authorTextView = (TextView) itemView.findViewById(R.id.author_item_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View wishView = inflater.inflate(R.layout.item_wish, parent, false);

        ViewHolder viewHolder = new ViewHolder(wishView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Wish wish = mWishes.get(position);

        TextView wishTextView = holder.wishTextView;
        wishTextView.setText(wish.getWish());

        TextView authorTextView = holder.authorTextView;
        authorTextView.setText(wish.getAuthor());

    }

    @Override
    public int getItemCount() {
        return mWishes.size();
    }


}
