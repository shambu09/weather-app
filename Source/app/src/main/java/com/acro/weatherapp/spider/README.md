# Implemented the spider package :
*  Class __Crawler__ : Crawls the _weather.com_ for the next day's forecast, Inherits from the __AsyncTask__
    * Params : 
        * A __SpiderCallBack__ Instance defining an __onCrawlMethod__ that is called when the Crawling is completed.
        * A __ConnectivityManager__ instance that is required for the network check
        * Two __double__ types for the execute method of the parent class __AsyncTask__ : __latitude__ and __longitude__.  
    * __getConnectivity__ method : returns a __boolean__ specifying whether the device is connected to a network. 
    * __sync_getWeather__ method : Starts the crawling process using the doubles __latitude__ and __longitude__
 that are passed to it and returns a __Response__ object as the output.
    * __doInBackground__ method : executes the __sync_getWeather__ method on a separate thread (asynchronously) returns a __Response__ object as the output.
    * __onPostExecute__ method : takes in the __Response__ object as input from the completed __doInBackground__ method and calls the __SpiderCallBack__'s __onCrawlCompleted__ method also passing the __Response__ object to it.
<br>

*  Class __Response__ : A utility class for handling the output of the crawler.
    * Params :
        * __String data__ for the Successful crawling operation.
        * __Exception exception__ for any exception occurred.
<br>

* Interface __SpiderCallBack__ : A interface for the CallBack of the crawling operation.
    * __onCrawlCompleted__ abstract method is initialized.
<br>

* Class __URL__ : A __URL__ class for handling and formatting the url strings.
    * Params : 
        * __String prefix__ (base url) for the website domain address.
        * __String suffix__ for the miscellaneous url parameters.
    * __buildUrl__ method : generates the operation url using the two positional __double__ types __latitude__ and __longitude__
 that are passed to it.
<br>

### An Example code for defining and executing the __Crawler AsyncTask__ :
```
public class MainActivity extends AppCompatActivity {
    TextView s;
    Double[] cords = {16.16, 75.66};
    ConnectivityManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = findViewById(R.id.h);
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public void click(View view) {
        new Crawler(new SpiderCallBack() {
            @Override
            public void onCrawlCompleted(Response response) {
                s.setText(response.data);
                if (response.exception != null)
                    response.exception.printStackTrace();
            }
        }, cm).execute(cords[0], cords[1]);
    }
}
```
