
// 환경설정 : 한번만 실행
void setup() {
  // 사용할 포트의 용도를 적어야 한다
  pinMode(13, OUTPUT);

}

// 계속해서 돌면서 반복 실행
void loop() {
  digitalWrite(13, HIGH);
  delay(1000);  // 1000 -> 1초
  digitalWrite(13, LOW);
  delay(1000);

}
