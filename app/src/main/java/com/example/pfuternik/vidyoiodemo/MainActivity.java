package com.example.pfuternik.vidyoiodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.ConnectorPkg;
import com.vidyo.VidyoClient.Connector.Connector;

public class MainActivity extends AppCompatActivity implements Connector.IConnect {

    private Connector vc;
    private FrameLayout videoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();
        videoFrame = (FrameLayout)findViewById(R.id.videoFrame);
    }

    public void Start(View v) {
        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
    }

    public void Connect(View v) {
        String token = "cHJvdmlzaW9uAHVzZXIxQDM2ZDI3OS52aWR5by5pbwA2Mzc1Njk3OTg1NQAAYjhmY2Y1MGZlYTgwYWYwZDQwYjA1MzIxMWY0ODU0MWUzOTYyNmFhMzVkYjg3NTcwMTMzMjRmOTY3NjNhNjEzYjVhYWI0ZDkxZDZjYzQ0NWU0YzYwNTE1NTQ3M2YxYWJk";
        vc.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", this);
    }

    public void Disconnect(View v) {
        vc.disconnect();
    }


    public void onSuccess() {

    }

    public void onFailure(Connector.ConnectorFailReason connectorFailReason) {

    }

    public void onDisconnected(Connector.ConnectorDisconnectReason connectorDisconnectReason) {

    }
}
