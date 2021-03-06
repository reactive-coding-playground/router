package com.eyeem.nanorouter.moustache.decorator;

import com.eyeem.nanorouter.moustache.MoustacheDecorator;
import com.eyeem.nanorouter.plugins.MoustachePlugin;
import com.eyeem.nanorouter.nano.ResponseWrapper;
import com.eyeem.router.AbstractRouter;

import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by vishna on 24/06/16.
 */
public class HeaderDecorator extends MoustacheDecorator implements MoustachePlugin.Config {

   Map<String, Object> tmpConfig;

   @Override public void onGenerateContext(Map<String, Object> context) {
      context.putAll(tmpConfig);
   }

   @Override
   public void configFor(AbstractRouter<ResponseWrapper, NanoHTTPD.IHTTPSession>.RouteContext context, Object config) {
      if (config instanceof Map) {
         tmpConfig = (Map<String, Object>) config;
      }
   }
}
