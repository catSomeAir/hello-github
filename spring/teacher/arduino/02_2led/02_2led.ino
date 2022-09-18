int ledR = 10;
int ledB = 11;

// 환경설정 : 한번만 실행
void setup() {
  // 사용할 포트의 용도를 적어야 한다
  pinMode(ledR, OUTPUT);
  pinMode(ledB, OUTPUT);

}

// 계속해서 돌면서 반복 실행
void loop() {
  // 아날로그로 사용하기로 했음 : 0-255
  analogWrite(ledR, 80);
  delay(200);
  analogWrite(ledR, 180);
  delay(200);
  analogWrite(ledR, 255);
  delay(200);
  analogWrite(ledR, 0);
  delay(200);

  analogWrite(ledB, 80);
  delay(200);
  analogWrite(ledB, 180);
  delay(200);
  analogWrite(ledB, 255);
  delay(200);
  analogWrite(ledB, 0);
  delay(200);

}
