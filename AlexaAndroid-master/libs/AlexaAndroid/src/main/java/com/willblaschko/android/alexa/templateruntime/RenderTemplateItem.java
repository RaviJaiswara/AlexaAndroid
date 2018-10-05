package com.willblaschko.android.alexa.templateruntime;

import android.content.Intent;
import android.util.Log;

import com.willblaschko.android.alexa.data.Directive;
import com.willblaschko.android.alexa.data.Event;
import com.willblaschko.android.alexa.interfaces.AvsItem;

public class RenderTemplateItem extends AvsItem {
    private String headerName;
    private Directive.Payload payload;

    public RenderTemplateItem(String token, String headerName, Directive.Payload payload) {
        super(token);

        this.headerName = headerName;
        this.payload = payload;

        Log.d("headerName", headerName);
        Log.d("payLoad", payload.toString());

    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public Directive.Payload getPayload() {
        return payload;
    }

    public void setPayload(Directive.Payload payload) {
        this.payload = payload;
    }
}
