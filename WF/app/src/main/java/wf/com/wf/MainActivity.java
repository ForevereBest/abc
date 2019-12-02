package wf.com.wf;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean mIsLight = false;
    private boolean isOpen = false;
    private Button btnOpenLight;
    private TextView tv_1;
    private Camera camera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        btnOpenLight = (Button) findViewById(R.id.open);
        tv_1 = (TextView) findViewById(R.id.tv_1);
    }

    private void initListener() {
        btnOpenLight.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open:
                if(!isOpen){
                    if (!mIsLight) {
                        if (camera == null) {
                            camera = Camera.open();
                        }
                        camera.startPreview();
                        Camera.Parameters parameters = camera.getParameters();
                        List<String> flashModes = parameters.getSupportedFlashModes();
                        if (flashModes == null) {
                            return;
                        }
                        String flashMode = parameters.getFlashMode();
                        if (!flashMode.contains(Camera.Parameters.FLASH_MODE_TORCH)) {
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            camera.setParameters(parameters);
                        }
                        mIsLight = true;
                        isOpen = true;
                        tv_1.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (mIsLight) {
                        Camera.Parameters parameters = camera.getParameters();
                        List<String> flashModes = parameters.getSupportedFlashModes();
                        if (flashModes == null) {
                            return;
                        }
                        String flashMode = parameters.getFlashMode();
                        if (!flashMode.contains(Camera.Parameters.FLASH_MODE_OFF)) {
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            camera.setParameters(parameters);
                        }
                        mIsLight = false;
                        isOpen = false;
                        tv_1.setVisibility(View.GONE);
                    }
                }

                break;
        }
    }
}
