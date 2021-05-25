package com.ykp.snacks.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Repository
public class util {

    public static final String apiType = "ali";
    public static final String privateStorage = "oos";
    public static final String token = "5680380fcae2cba59a4624088d9ec276";
    public static final String url = "https://www.hualigs.cn/api/upload";

    public String getOpenid(String code) {
        String path = "https://api.weixin.qq.com/sns/jscode2session?appid=wx3aa5fd77324397d1&secret=8da3f2130f904f306d8409720e643ae0&js_code="+code+"&grant_type=authorization_code";
        String data = "";
        String openId = "";
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
//          conn.setRequestMethod("POST");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                openId = str;
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            //System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openId;
    }



    public JSONObject uploadImg(MultipartFile file) throws Exception {
        //将multipartFileToFile类型的文件转换为File类型的
        File image = multipartFileToFile(file);
        //告诉服务器图片所传的文件类型为：所有图片
        RequestBody fileBody = RequestBody.create(image,MediaType.parse("image/*"));
        OkHttpClient client = new OkHttpClient();
        JSONObject jsonObject = null;

        //创建请求体
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                //参数名、文件名、RequestBody（可通过RequestBody.create创建）
                .addFormDataPart("image", image.getName(), fileBody)
                .addFormDataPart("apiType", apiType)
//                .addFormDataPart("privateStorage", privateStorage)
                .addFormDataPart("token", token)
                .build();

        //创建request请求
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response;
        try {
            //执行request请求
            response = client.newCall(request).execute();

            String jsonString = response.body().string();
            jsonObject = JSON.parseObject(jsonString);
            System.out.println("jsonObject = "+jsonObject);
            if (!jsonObject.getString("code").equals("200")) {
                System.out.println("图片上传土豆图床错误。。。。");
            } else {
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return jsonObject;
    }


    //MultipartFile转换为File
    public File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
