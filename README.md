## getChildren
- 키, 값을 배열로 하나하나 가져 옴

![스크린샷 2017-07-03 오후 7.27.29](http://i.imgur.com/8GZWgJ6.png)
```java
// 이벤트 리스너 담기
    userRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            List<User> data = new ArrayList<User>();
            for(DataSnapshot item : dataSnapshot.getChildren()){  // getChildren 키,값 하나하나의 배열로 가져옴
                String key = item.getKey();  // 키
                Log.i("Firebase","key "+key);
                User user = item.getValue(User.class);  // 값
                data.add(user);  // 키,값을 가져와서 하나하나 추가해줌 
            }
            refreshData(data);
            dialog.dismiss();
        }

        @Override
        public void onCancelled(DatabaseError error) {
        }
    });
```
