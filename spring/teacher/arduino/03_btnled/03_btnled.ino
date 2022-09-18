int ledR = 10;
int btn1 = 8;

void setup() {
  // 시리얼 모니터를 사용할려면 초기화를 시켜야한다
  // 통신속도를 9600으로 초기화
  Serial.begin(9600);
  
  pinMode(ledR, OUTPUT);
  pinMode(btn1, INPUT);
}

void loop() {
  int val = digitalRead(btn1);

  Serial.println(val);

  if(val == 1){
    // 불을 켠다
    digitalWrite(ledR, HIGH);
  }else {
    // 불을 끈다
    digitalWrite(ledR, LOW);
  }

  delay(100);  
}
