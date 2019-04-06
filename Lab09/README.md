## Lab 9 - 01
### Requirements:
- Working with AsynTask

### Output:
<img width="400" src="https://github.com/cminhho/TDTU-LapTrinhUngDungDiDong/blob/master/Lab09/sceenshots/exercise_01.png" alt="Working with AsynTask"/>


## Lab 9 - 02
### Requirements:
- Working with Service + AsynTask

### Output:
<img width="400" src="https://github.com/cminhho/TDTU-LapTrinhUngDungDiDong/blob/master/Lab09/sceenshots/exercise_02.png" alt="Working with Service + AsynTask"/>

## Lab 9 - 03
### Requirements:
- Working with IntentService + AsynTask

### Output:
<img width="400" src="https://github.com/cminhho/TDTU-LapTrinhUngDungDiDong/blob/master/Lab09/sceenshots/exercise_02.png" alt="Working with Service + AsynTask"/>


## Questions/Anwsers
<b>Question:</b> 
AsyncTask vs IntentService vs Service?
<b>Anwsers:</b>
Service is a base class of service implementation. Service class is run in the application’s main thread which may reduce the application performance.

IntentService, which is a direct subclass of Service is borned to make things easier. The IntentService is used to perform a certain task in the background. Once done, the instance of IntentService terminate itself automatically. Examples for its usage would be to download a certain resources from the Internet.

AsyncTask is designed to be a helper class around Thread and Handler and does not constitute a generic threading framework. AsyncTasks should ideally be used for short operations (a few seconds at the most.) An asynchronous task is defined by a computation that runs on a background thread and whose result is published on the UI thread
