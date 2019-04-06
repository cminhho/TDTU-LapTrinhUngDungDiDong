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
### Question: AsyncTask vs IntentService vs Service?
### Anwsers
<b>Service</b> 
- Running in the application’s main thread
- Using for long operations.

<b>IntentService</b> 
- Using to perform a single background thread. 
- Once done, the instance of IntentService terminate itself automatically. 
- Using for long operations.

<b>AsyncTask</b> 
- Running on a background thread and whose result is published on the UI thread
- Using for short operations (a few seconds at the most.)
