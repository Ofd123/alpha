//package com.example.alphatest.Receivers;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//
//public class AllMsgsReceiver extends BroadcastReceiver
//{
//    public static final String ACTION_SEND_MSG_TO_ACTIVITY = "com.example.alphatest.SEND_MSG_TO_ACTIVITY";
//    public static final String EXTRA_MESSAGE = "com.example.alphatest.MESSAGE";
//
//    @Override
//    public void onReceive(Context context, Intent intent)
//    {
//        try
//        {
//            System.out.println("All msgs receiver start");
//            String action = intent.getStringExtra("msg");
//            if(action != null)
//            {
//                Intent sendIntent = new Intent(ACTION_SEND_MSG_TO_ACTIVITY);
//                sendIntent.setAction("service.to.activity.transfer");
//                sendIntent.putExtra("message", action);
//                context.sendBroadcast(sendIntent);
////              LocalBroadcastManager.getInstance(context).sendBroadcast(sendIntent);
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}