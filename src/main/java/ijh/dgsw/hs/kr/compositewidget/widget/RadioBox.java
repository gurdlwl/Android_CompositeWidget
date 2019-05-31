package ijh.dgsw.hs.kr.compositewidget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ijh.dgsw.hs.kr.compositewidget.R;

public class RadioBox extends CardView implements RadioGroup.OnCheckedChangeListener {

    private ConstraintLayout layout;
    private TextView textViewTitle;
    private RadioGroup radioGroup;
    private int selected;

    private String title;
    private CharSequence[] entries;

    public RadioBox(@NonNull Context context) {
        super(context);
        init(R.layout.widget_radio_box, context, null);
    }

    public RadioBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(R.layout.widget_radio_box, context, attrs);
    }

    public RadioBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(R.layout.widget_radio_box, context, attrs);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for(int i = 0; i<group.getChildCount(); i++){
            if(checkedId == group.getChildAt(i).getId()){
                selected=i;
                return;
            }
        }
        selected = 0;
    }

    private boolean getAttributes(Context context, AttributeSet attrs){
        if(attrs == null)
            return false;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.box);
        title = typedArray.getString(R.styleable.box_boxTitle);
        entries = typedArray.getTextArray(R.styleable.box_android_entries);
        typedArray.recycle();

        return true;
    }

    private void init(int layoutId, Context context, AttributeSet attrs){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = (ConstraintLayout)inflater.inflate(layoutId, null);
        addView(layout);

        if(getAttributes(context, attrs)){
            textViewTitle = layout.findViewById(R.id.boxTitle);
            textViewTitle.setText(title);
            radioGroup = layout.findViewById(R.id.radioGroup);
            if(entries != null){
                for(CharSequence i:entries){
                    RadioButton radio = new RadioButton(getContext());
                    radio.setText(i);
                    radioGroup.addView(radio);
                }
            }
            radioGroup.setOnCheckedChangeListener(this);
            radioGroup.check(radioGroup.getChildAt(0).getId());
        }
    }

    public String getValue(){
        return entries[selected].toString();
    }

    public int getSelectedIndex(){
        return selected;
    }
}







