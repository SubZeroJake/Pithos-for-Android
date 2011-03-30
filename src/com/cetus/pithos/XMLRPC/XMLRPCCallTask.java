package com.cetus.pithos.XMLRPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.cetus.pithos.Constants.USER_AGENT;


import android.os.AsyncTask;
import android.util.Log;

public class XMLRPCCallTask extends AsyncTask<Object,Object,Object> {
    String url;
	String data;
	String response;
	RPCCallback errorCb = null;
    RPCCallback successCb = null;
	
	public XMLRPCCallTask(String url, String data, RPCCallback successCb, RPCCallback errorCb) {
    	this.url = url;
		this.data = data;
		this.successCb = successCb;
    	this.errorCb   = errorCb;
    }
	
	@Override
	protected Object doInBackground(Object... arg0) {
		
		String responseString = "";
		
		try {
			URL text = new URL(this.url);
			
			HttpURLConnection http =
				(HttpURLConnection)text.openConnection();
			
			
			
			http.setRequestProperty("http.agent", USER_AGENT);
			http.setRequestProperty("Content-Type", "text/xml");
			http.setDoOutput(true);
			
			OutputStreamWriter out = new OutputStreamWriter(
                    http.getOutputStream());
			
			// Data to post here
			out.write(this.data);
			out.close();
			
			InputStream inputStream = http.getInputStream();
			
			BufferedReader bufferedReader = new BufferedReader(
	                new InputStreamReader(inputStream));
			
			Log.d("Net", "responsecode = " + http.getResponseCode());
			
			String temp;
			while ((temp = bufferedReader.readLine()) != null) {
		    	responseString += temp;
		    	Log.d("Net", "content line = " + temp);
		    }
		    
			this.response = responseString;
			// for testing
			//responseString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><methodResponse><params><param><value><array><data><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>462447443963225322</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Boards Of Canada</value></member><member><name>musicId</name><value>R39559</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/boards+of+canada</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R39559</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>396505d33963fcb5155d47049fc68566af925f7dd7ee60c2</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Boards Of Canada Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>405851216794821866</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Rock</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>429963601281230058</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Josh Rouse</value></member><member><name>musicId</name><value>R16457</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/josh+rouse</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R16457</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>aa4f4c098badb7a8c0655dd053f01001097373da80590865</value></member><member><name>adGenre</name><value>rock</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Josh Rouse Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>375482112930161898</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Folk</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>414007239430841578</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Antoine Dufour</value></member><member><name>musicId</name><value>R268432</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/antoine+dufour</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R268432</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>cf2a9d1314b1b03d075ab860cabf5a19af925f7dd7ee60c2</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Antoine Dufour Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>360437521097106666</value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value><value>Rock</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>352223731150955754</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Bjork</value></member><member><name>musicId</name><value>R63490</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/bjork</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R63490</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>809b01e16d3f2233fcd6f3b07a6da422336bc76d4b0139da</value></member><member><name>adGenre</name><value>alternative</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Bjork Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>303098517989565674</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>song</name><value><struct><member><name>songDetailUrl</name><value>http://www.pandora.com/music/song/brian+eno/lizard+point</value></member><member><name>identity</name><value>1706ae1a032cd5fea71934fa7ea448e4</value></member><member><name>artistMusicId</name><value>R124640</value></member><member><name>musicId</name><value>S186927</value></member><member><name>artistSummary</name><value>Brian Eno</value></member><member><name>songTitle</name><value>Lizard Point</value></member><member><name>score</name><value></value></member></struct></value></member><member><name>seedId</name><value>351398191192024298</value></member><member><name>musicId</name><value>S186927</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>869a725073fbdb159d0273d08d6755eabba91e12fdd0b038</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Ambient</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>185592640882287850</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Rock</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>322881515312063722</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Thrice</value></member><member><name>musicId</name><value>R20708</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/thrice</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R20708</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>78bdb57c04f8500c10b0a1b31c40d078ebf20850b0c936ea</value></member><member><name>adGenre</name><value>alternative</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Thrice Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>275991441786217706</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>309260026532799722</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Baxter</value></member><member><name>musicId</name><value>R4068</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/baxter</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R4068</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>d28952870fe52ef77a9a3fbdd4f0d5d1bba91e12fdd0b038</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Baxter Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>263361076840047850</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value><value>Rock</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>309258703682872554</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Goldfrapp</value></member><member><name>musicId</name><value>R15703</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/goldfrapp</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R15703</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>356403c6982481d24a5b9da5c384d1e9af925f7dd7ee60c2</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Goldfrapp Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>263359771169989866</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>308230269468878058</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Sia</value></member><member><name>musicId</name><value>R161726</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/sia</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R161726</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>89305a676671ae69a642b2b8a567bad600ea737c935f5d4f</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Sia Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>262400344195540202</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>299517485927310570</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>M83</value></member><member><name>musicId</name><value>R60422</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/m83</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R60422</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>a80fb47ccf4a6059254cb10c0aeaaa56fb0c2cad41b899d3</value></member><member><name>adGenre</name><value>indie</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>M83 Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>254303712367289578</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>0</boolean></value></member><member><name>originalStationId</name><value>147055960803394318</value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>30032654</value></member><member><name>initialSeed</name><value><struct><member><name>song</name><value><struct><member><name>songDetailUrl</name><value>http://www.pandora.com/music/song/ltj+bukem/rhodes+to+freedom</value></member><member><name>identity</name><value>11dda373231fc8b718964dc83a9cc985</value></member><member><name>artistMusicId</name><value>R169121</value></member><member><name>musicId</name><value>S208988</value></member><member><name>artistSummary</name><value>LTJ Bukem</value></member><member><name>songTitle</name><value>Rhodes To Freedom</value></member><member><name>score</name><value></value></member></struct></value></member><member><name>seedId</name><value>138005313659486990</value></member><member><name>musicId</name><value>S208988</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>2cd3c0074fa3dcd83ea16f844c8bbb85c083d46737a7e8a7</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Liquid Drum &amp; Bass</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>209011418215163114</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>0</boolean></value></member><member><name>originalStationId</name><value>145191756018369294</value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value><value>Rock</value></data></array></value></member><member><name>originalCreatorId</name><value>30032654</value></member><member><name>initialSeed</name><value><struct><member><name>song</name><value><struct><member><name>songDetailUrl</name><value>http://www.pandora.com/music/song/extrawelt/lost+in+willaura</value></member><member><name>identity</name><value>3bd0a87466df8923fdd6e6ebf31208ae</value></member><member><name>artistMusicId</name><value>R201493</value></member><member><name>musicId</name><value>S1254568</value></member><member><name>artistSummary</name><value>Extrawelt</value></member><member><name>songTitle</name><value>Lost In Willaura</value></member><member><name>score</name><value></value></member></struct></value></member><member><name>seedId</name><value>136259452403335950</value></member><member><name>musicId</name><value>S1254568</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>974fc51d2f0610c5c59575ebf7c0a7dd9a20949ec58d2630</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Minimal Techno</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>209011366675555562</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>0</boolean></value></member><member><name>originalStationId</name><value>145190879845040910</value></member><member><name>genre</name><value><array><data></data></array></value></member><member><name>originalCreatorId</name><value>30032654</value></member><member><name>initialSeed</name><value><struct><member><name>song</name><value><struct><member><name>songDetailUrl</name><value>http://www.pandora.com/music/song/above+beyond/no+1+on+earth+above+beyond+mix</value></member><member><name>identity</name><value>886f85e14f9d366d6decaa11e8428f57</value></member><member><name>artistMusicId</name><value>R158946</value></member><member><name>musicId</name><value>S1022098</value></member><member><name>artistSummary</name><value>Above &amp; Beyond</value></member><member><name>songTitle</name><value>No One On Earth (Above &amp; Beyond Mix)</value></member><member><name>score</name><value></value></member></struct></value></member><member><name>seedId</name><value>136258722258895630</value></member><member><name>musicId</name><value>S1022098</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>b8296f6e669e26a97b2fb334bddc83b53e77e7f774003ae0</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Trance</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>177490094884070634</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>0</boolean></value></member><member><name>originalStationId</name><value>184536254899405715</value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value><value>Tween</value><value>Rap / Hip-Hop</value><value>R&amp;B / Soul</value></data></array></value></member><member><name>originalCreatorId</name><value>24494995</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>227691699742557075</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Usher</value></member><member><name>musicId</name><value>R43016</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/usher</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R43016</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_AUTOMATIC</value></member><member><name>stationIdToken</name><value>0cfae9406881a9117b3170cc1793f9fb6952b56c07c96377</value></member><member><name>adGenre</name><value>rhythmandblues</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>R&amp;B / Soul</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>177488067659506922</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>0</boolean></value></member><member><name>originalStationId</name><value>184497746222629779</value></member><member><name>genre</name><value><array><data><value>Rap / Hip-Hop</value><value>R&amp;B / Soul</value></data></array></value></member><member><name>originalCreatorId</name><value>24494995</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>227652216108204947</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Missy Elliott</value></member><member><name>musicId</name><value>R4487</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/missy+elliott</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R158753</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_AUTOMATIC</value></member><member><name>stationIdToken</name><value>80b84e1568eb1f45031b5348e8637678d0023c358e8c3b4e</value></member><member><name>adGenre</name><value>rap</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Hip Hop / Urban</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>177487887270880490</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>204810566537520362</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>City And Colour</value></member><member><name>musicId</name><value>R180259</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/city+colour</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R180259</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>0c8062d368c93f7bc37cba2a4f521921bba91e12fdd0b038</value></member><member><name>adGenre</name><value>rock</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>City And Colour Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>166696824889353450</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>198030007178044650</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Brian Eno</value></member><member><name>musicId</name><value>R124640</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/brian+eno</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R124640</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>b2e0dc779922a51e078bfe9a2f478457af925f7dd7ee60c2</value></member><member><name>adGenre</name><value>alternative</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Brian Eno Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>161170580663903466</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value><value>New Age</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>197033763743933674</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Stars Of The Lid</value></member><member><name>musicId</name><value>R171566</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/stars+of+lid</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R171566</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>b553b7fcb1a305efb23fdcaabbd3ee65097373da80590865</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Stars Of The Lid Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>160273757132760298</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>f036eaea58669059f039db4a8c21fa8393d26a2c47d21416</value></member><member><name>isQuickMix</name><value><boolean>1</boolean></value></member><member><name>stationName</name><value>davidcollins4481's QuickMix</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>155678507198260458</value></member><member><name>quickMixType</name><value>RANDOM</value></member><member><name>quickMixStationIds</name><value><array><data><value>375482112930161898</value><value>275991441786217706</value><value>263361076840047850</value><value>166696824889353450</value></data></array></value></member></struct></value><value><struct><member><name>isCreator</name><value><boolean>1</boolean></value></member><member><name>originalStationId</name><value></value></member><member><name>genre</name><value><array><data><value>Dance / Electronica</value></data></array></value></member><member><name>originalCreatorId</name><value>146220266</value></member><member><name>initialSeed</name><value><struct><member><name>seedId</name><value>183894668511487210</value></member><member><name>artist</name><value><struct><member><name>score</name><value></value></member><member><name>artistName</name><value>Aphex Twin</value></member><member><name>musicId</name><value>R39843</value></member><member><name>isComposer</name><value><boolean>0</boolean></value></member><member><name>artistDetailUrl</name><value>http://www.pandora.com/music/artist/aphex+twin</value></member><member><name>likelyMatch</name><value><boolean>0</boolean></value></member></struct></value></member><member><name>musicId</name><value>R39843</value></member></struct></value></member><member><name>isNew</name><value><boolean>0</boolean></value></member><member><name>transformType</name><value>TRANSFORM_CONFIRM</value></member><member><name>stationIdToken</name><value>3553bb9213a03d042f3d39d9cf78075d00ea737c935f5d4f</value></member><member><name>adGenre</name><value>electronica</value></member><member><name>isQuickMix</name><value><boolean>0</boolean></value></member><member><name>stationName</name><value>Aphex Twin Radio</value></member><member><name>isOnDemandStation</name><value><boolean>0</boolean></value></member><member><name>stationId</name><value>148875231756756202</value></member><member><name>antiTarget</name><value><boolean>0</boolean></value></member></struct></value></data></array></value></param></params></methodResponse>";
		    
		} catch (MalformedURLException mue) {
			errorCb.fire(new XMLRPCResponse(responseString));
			mue.printStackTrace();
		} catch (IOException e) {
			errorCb.fire(new XMLRPCResponse(responseString));
			// TODO Auto-generated catch block
			// message saying "cannot connect to internet"
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Object result) { 
		super.onPostExecute(result);
		this.successCb.fire(new XMLRPCResponse(this.response));
	}	
}