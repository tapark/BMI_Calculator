# BMI 계산기

### MainActivity.kt 와 activity_main.xml 을 연결
~~~kotlin
setContentView(R.layout.activity_main)
~~~

### MainActivity.kt 에서 activity_main.xml 의 EditText, Button 불러오기
~~~kotlin
val heightEditText: EditText = findViewById<EditText>(R.id.heightEditText)
val weightEditText: EditText = findViewById<EditText>(R.id.weightEditTExt)

val resultButton: Button = findViewById<Button>(R.id.resultButton)
~~~

### EditText의 text 확인
~~~kotlin
heightEditText.text
// 필요한 자료형으로 변환
val weight: Int = heightEditText.text.toString().toInt()
~~~

### Button 클릭
~~~kotlin
resultButton.setOnClickListener {
	//todo Button 클릭 시 발생하는 이벤트(결과)
}
~~~

### Toast 메세지 출력
~~~kotlin
Toast.makeText(this, "출력할 메세지", Toast.LENGTH_LONG).show()
~~~

### Logcat 에서 Log 확인
~~~kotlin
Log.d(tag: String, message: String)
// tag는 Log 필터링 시 식별할 목적으로 사용
~~~

### ResultActivity.kt, activity_result.xml 생성
~~~kotlin
// in ResultActivity.kt
setContentView(R.layout.activity_result)
// in AdroidMainifest.xml
<activity android:name=".ResultActivity">
</activity>
~~~

### MainActivity.kt -> ResultActivity.kt 속성(property) 전달 + Activity 이동
~~~kotlin
// in ResultActivity.kt
// target을 지정 : ResultActivity::class.java
val intent = Intent(this, ResultActivity::class.java)
// poperty를 key값에 저장
intent.putExtra(key, poperty)
intent.putExtra("height", height)
// Activity 이동
startActivity(intent)

// in ResultActivity.kt
// key값에 해당하는 poperty를 value에 저장 (초기값 : 0)
val height = intent.getIntExtra("height", 0)
~~~
