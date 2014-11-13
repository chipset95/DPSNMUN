package chipset.dpsnmun.whsr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import chipset.dpsnmun.whsr.R;

/**
 * Developer: chipset
 * Package : chipset.dpsnmun.whsr.adapters
 * Project : WHSR
 * Date : 9/11/14
 */
public class MessagesListViewAdapter extends BaseAdapter {

    Context context;
    String[] messages;
    LayoutInflater layoutInflater;

    public MessagesListViewAdapter(Context context, String[] messages) {
        this.context = context;
        this.messages = messages;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return messages.length;
    }

    @Override
    public Object getItem(int i) {
        return messages[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = layoutInflater.inflate(R.layout.messages_list_item, null);
        TextView messagesTitleTextView = (TextView) view.findViewById(R.id.messages_list_title);
        messagesTitleTextView.setText(messages[i]);
        return view;
    }
}
