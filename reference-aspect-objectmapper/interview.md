# Interview Guide

- New Interview Explanation
  - Peer Programming Evaluation
  - Placement Evaluation
  - S4 Confirmation Evaluation
  - Client Field Placement
- Before the Interview
  - Being Scheduled
    - RDC Interview Spreadsheet
    - WebEx Meeeting Email
    - Trello Card
  - Setting Up The Interview Station
  - Having the Scoresheet Handy
- During the Interview
  - Explanation
  - WebEx
  - In Person
  - PR Responses
  - Red Flags
- After the Interview
  - Filling Rest of the Spreadsheet
  - Trello Card
- Interview Retros
- Explanation
  - Stack
  - Linked List
  - TDD
- Code Implementation Order


## New Interview Explanation
This section was discussed in the interview training. This section will be filled later on.

## Before the Interview

### Being Scheduled
You will be assigned a day to do your interviews. Check the RDC Interview Spreadsheet on the day you interview to see if you have an interview or not. Hopefully, earlier than the day you were supposed to do your interview, you will have received an email from a recruiter with the date and time of you interview. If everything looks good, accept the meeting invite. If you have any questions that are not present in the following FAQ, email me!

Frequently Asked Questions:
- What do I do if the meeting invite has a different time as the interview timeslot I'm assigned to?
  - Send an email to your recruiter, whoever sent you the meeting invite in the first place, to clarify the time. 
- What do I do if I'm assigned an interview on the spreadsheet, but I did not get a meeting invite?
  - Send an email to your recruiter, based on the color coding on the spreadsheet.
    - Melissa (Blue): melissa.kramer@cognizant.com
    - Sony (Green): sony.patnaik@cognizant.com
    - Nisha (Yellow / Red): nisha.sanger@cognizant.com
- I know I'm going to be OOO ahead of time, is there a way I can make it so I'm not going to be booked?
    - Please add me, BronwenFerry.Hughes@cognizant.com to the OOO email, and I'll change it for you. 
- I'm unable to conduct my interview due to me having client engagements or I'm OOO, what should I do?
    - Find someone to take over your interview. Make sure they are from the spreadsheet and can conduct an interview in the same language. If your interview is taking place on your webex and you're unable to log in for them, email the recruiter who sent you the meeting invite to move it to the webex of the person who can take your interview. 
- I'm unable to conduct my interview due to me being sick, what can I do?
    - Try to find someone to cover your slot. If you're really that sick, email me at BronwenFerry.Hughes@cognizant.com, and I'll try my best to find a replacement.

#### RDC Interview Spreadsheet
If you do not have access to [this spreadsheet](https://cognizantonline.sharepoint.com/:x:/r/sites/cde/Shared%20Documents/Hiring/RDC%20Interview%20Schedule.xlsx?d=wb91ad5c468c1498d97168878e62689e3&csf=1&e=VeGqhZ), please email bronwenferry.hughes@cognizant.com to give you access. 

#### Meeting Invite Email
This email will provide details regarding your interview. Whoever scheduled your interview will email you with a meeting invite. The email contents will vary depending on who scheduled it, but there are several things that will be consistent across recruiters. It will include a meeting invite, where and what time your interviewee will take the interview, and the webex link associated with it, if it's a webex meeting. Please double check that the meeting invite and the time provided below are the same times. Please take note of the timezone as well. If everything looks good and you are okay to do the interview, please accept the meeting. 

#### Trello Card
Find the Trello card on the [RDC Candidate Board](https://trello.com/b/ZGU5Xrvq/rdc-candidates) with your interviewee's name. When you click on the card, you can see the interviewee's resume as well. Make sure there's only one card with that person's name. If there's more than one card, please email me the issue with your interviewee's name. If you do not have access to this board, please email me.

### Setting Up The Interview Station
Based on the meeting invitation you were emailed, there should be a webex link. This will be the webex you will do your interview on. If you find that the link you were given is not yours or the recruiters, email the recruiters for clarification.
To access Webex on the interview stations, go to the [Cognizant Webex](https://cognizantcorp.webex.com) site. If it's on your webex, sign in to your own, or click on the link in the meeting invitation.

When you start the meeting, check your audio connection. Make sure you can be heard and you can hear properly. If you use webcam, make sure the webcam works. Mute yourself until the interviewee shows up. Wait at least 15 minutes for the interviewee to come to mark them as a no-show. You can also check your email to see if your interview got canceled or rescheduled.

We are trying to make the interview stations have the same headphones, webcams, and image, so that the stations should all be the same. We understand people are "reserving" stations, and we are trying to deal wth this issue.

### Having the Scoresheet Handy
The scoresheet is now accessible through [this link](http://dela-scoresheet.cfapps.io/).

The scoresheet was made to be more objective. You just have to fill out the parts that have the text with `Please Fill Out` and `<choose>`. 

![](pictures/interview_scoresheet_1.png)


In the first part, enter the candidates name, your name, and the date you conducted the interview. Do not touch the Final Assessed Level, since it will automatically change based on your answers throughout the spreadsheet.


![](pictures/interview_scoresheet_2.png)

You're supposed to have the spreadsheet handy whilst doing the interview. The topic section contains the method (isEmpty) and the implementation associated with the method. (isEmpty Returns True On Empty Collection). The number of times helped necessary is the objective part. We define help by when you have to actually give them the answer on how to implement the code. Different implementations have different allowed numbers of help. isEmpty and other small implementations only allow for up to 3 helps. Big implementations like refactoring to a linked list and contains allow for 5 helps since they can be tricky to implement. If you find that a person exceeds the amount of help available, just leave it at the maximum allowed. 

- Help
  - When someone is absolutely stuck or in a bad direction confidently and would take unreasonable amount of time to complete a task.
    - Ex: When they really want to use an array, despite being told not to.
    - Ex: You give them a node, but they don't know what to do with it.
    - Ex: Push and Pop are totally wrong, so you have to suggest the better version in order to make sure later functions are working properly.
  - When someone just admits to not knowing how to do something.
    - Ex: How do you test exceptions?
  - When you have to write an implementation for them.
    - Don't immediately write the implementation for them. Give them about 1-2 minutes to tell you how to implement something. Try to ask them to explain their thought process. Try to get the answer out of them.
- Not Help
  - When you're having a conversation and they finally tell you what to do after.
    - Ex: You can ask them, "So we just tested isEmpty returning true, and then what's the other scenario?" If they say isEmpty returns false, and they can implement that, that's not help.
  - When they know how to properly implement it in another language.
    - Ex: "I know in JS you can do this, this is how you do it, but I'm not entirely sure how to do this in Java."
  - When someone asks a question just to confirm the test associated with the implementation.
  - When someone clarifies anything that has been previously mentioned.
    -  Ex: What does push return?
    -  Ex: You said I couldn't use certain classes. What were they again? 
  - Anything that doesn't *directly* contribute to the writing of the code.
    - Ex: How does TDD work?
    - Ex: How does the method contains work?

The notes section is an optional section for any clarifications and/or if you wanted to make an important note about a certain implementation. 

![](pictures/interview_scoresheet_3.png)

The bonus section at the bottom allows for people who finish the interview early, to accumulate more points incase they did not pass the point threshold. Each point allows for a point extra if they know how to implement it without any help. Most of the implementation is similiar to previous code. Try to not spend too much time in one section. You can suggest the four implementations and see if they can knock one out easily for more points. 

![](pictures/interview_scoresheet_4.png)

This is the breakdown of points. Base points will equal to 100 points if they got everything perfect with no help up to contains. Bonus points will equal up to 4 points if they got everything perfect in the bonus section. Their total will be calculated and will be used in the formula to determine if they pass or not.

![](pictures/interview_scoresheet_5.png)

The behavioral section allows to test for cutural fit for the company. Choose either yes or no in this section.
This section will also contribute to the formula if they pass or not.

![](pictures/interview_scoresheet_6.png)

Do not change anything in the final verdict section, as it is completely calculated. The Passed Behavioral and Final Pass/Fail will be considered incomplete if a section is not completed. If you see those, please complete the questions before handing in the worksheet. To pass an interviewee, we check if they have finished contains, have points greater than 92, and passed the behavioral check. If they are all Yes, they will Pass. If there is at least one No, they will Fail. 

Download it as a pdf afterwards and attach that to the associated Trello Card. Downloading it as a pdf will erase the test cases, so only we know what the test cases will be. :)


## During the Interview

### Explanation
Will come.

### WebEx
Please arrive on WebEx at least a few minutes earlier before you should start. Make sure your audio and microphone is working properly. Mute yourself until your interviewee comes, just for safety's sake. :)

### In Person
Your person should arrive early to the studios. Please great them with a nice, firm handshake, and walk them to the interview station. Make sure there are two chairs beforehand, too. To deal with the spreadsheet issue, you can do the following
- Have the spreadsheet on the other monitor and point it to you
- Print out the spreadsheet and mark it in front of them
- Have someone shadow you and keep score for you

### PR Responses
- Someone wants to go further than what you need to
  - "We understand you want to go ahead, but TDD requires you to do the simplest solution to pass the test. We want to make sure we have 100% test coverage, and going further than you need to might make you miss some test coverage."
- Someone asks "How did I do?"
  - "I'll pass your result to your recruiter, and your recruiter will get back to you."

### Red Flags
- Use of Search Engines
- Stubborn and doesn't want to do it the way the studio does TDD
- Being inconsiderate, not friendly, or rude.

## After the Interview

### Filling the Rest of the Spreadsheet
Please make sure that you have the scoresheet finished before doing anything. We want to have the recruiters be able to schedule them if they're able to move on to the next section.

### Trello Card
Find the Trello card on the [RDC Candidate Board](https://trello.com/b/ZGU5Xrvq/rdc-candidates) with your interviewee's name. Change the label to their result, so Passed, Failed, No Show, and so on. Attach the spreadsheet to the Trello card and include any comments that the next interviewer might would need to know. While you're still in the card editing screen, move the card to *Paired Programming Evaluation Complete* and Position 1. 

## Explanation

### Stack
LIFO (Last In First Out) Data Structure. A stack has the ability to peek, pop, and push. Peeking lets you only see the top of the stack. Popping, like peek, lets you see the top of the stack, but it also removes the top of the stack. Pushing adds a value to the top of the stack. For the interview, we will just assume that the _Stack_ part only has the capacity for one value.

![Stack](pictures/Lifo_stack.png)

### Linked List
Linked List is also a LIFO (Last In First Out) Data Structure. The difference between a Linked List and a Stack, is that a Linked List is made up of Nodes. A node has the data value, which we're using an Object, and a reference to the next node. The class will be included in the same Collection class file. You can add constructors in the node class for ease. 

```java
class Node {
    Object data;
    Node next;

    // Optional constructor for ease
    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
```

![Linked Lisst](pictures/Lifo_LL.jpg)
### TDD
#### Red, Green, Refactor
- Red
  - The test MUST fail. Some people would consider the compiler throwing you an error to be a red stage, but for true pure TDD, an assertion error is the red stage.
  - Red is the stage we want to make sure we know we are testing something, and not just getting a false positive. We do not want to write implementation code knowing that it will pass the test no matter what. 
- Green
  - Green indicates, if the red stage is properly done, that we have made a test pass. We can either write a new test, or head over to the refactor stage.
- Refactor
  - If all your tests are passing, you are able to refactor your code with the insurance that you have not broken any functionality, provided you constantly get passing tests while doing so. In some cases, you might need to fix some tests, because the tests might have not been properly written. 

#### Arrange, Act, Assert
 Similar to Given, When, Then, it allows for a very easy way to remember how to set up your tests. 
 - Arrange the test in a way that prior conditions are met
 - Act or execute the method that you need to test
 - Assert what you want to test.

Example:

Given a one sized stack, When I pop the stack, Then the stack should be empty. 
```java
@Test
public void isEmpty_ReturnsTrue_IfPopIsCalled() {
  // Arrange - We need to provide a one sized stack.
  stack.push(5);

  // Act - I'm testing pop's functionality
  stack.pop();

  // Assert - If I pop, stack should be empty!
  assertTrue(stack.isEmpty());
}
```

## Code Implementation Order

### Test 1 - isEmpty - Returns True If Stack Is Empty - TDD Test
```java
@Test
public void isEmpty_ReturnsTrue_IfStackIsEmpty() {
  assertTrue(stack.isEmpty());
}
```
### Test 1 - isEmpty - Returns True If Stack Is Empty - TDD RED
```java
public boolean isEmpty() {
  return false;
}
```
### Test 1 - isEmpty - Returns True If Stack Is Empty - TDD GREEN
```java
public boolean isEmpty() {
  return true;
}
```

---
### Test 2 - push - isEmpty Returns False After Calling Push With Value - TDD Test
```java
@Test
public void isEmpty_ReturnsFalse_IfPushIsCalled() {
  stack.push(1);
  assertFalse(stack.isEmpty());
}
```
### Test 2 - push - isEmpty Returns False After Calling Push With Value - TDD RED
```java
public void push(Object data) {
}
```
### Test 2 - push - isEmpty Returns False After Calling Push With Value - TDD GREEN
```java
Object data;

public boolean isEmpty() {
  return true;
  return data == null;
}

public void push(Object data) {
  this.data = data;
}
```
---
### Test 3a - peek - Peek Returns Most Recent Push Value - TDD Test
```java
@Test
public void peek_ReturnsPushedValue_IfPushIsCalled() {
  stack.push(2);
  assertEquals(2, stack.peek());
}
```
### Test 3a - peek - Peek Returns Most Recent Push Value - TDD RED
```java
public Object peek() {
  return null;
}
```
### Test 3a - peek - Peek Returns Most Recent Push Value - TDD GREEN
```java
public Object peek() {
  return data;
}
```
---
### Test 3b - peek - Peek Returns Null If Stack Is Empty - TDD Test GREEN (Sanity Check)
```java
@Test
public void peek_ReturnsNull_IfStackIsEmpty() {
  assertNull(stack.peek());
}
```
---
### Test 4a - pop1 - Pop Returns Most Recent Push Value - TDD Test
```java
@Test
public void pop_ReturnsPushValue_IfStackIsNotEmpty() {
  stack.push(3);
  assertEquals(3, stack.pop());
}
```
### Test 4a - pop1 - Pop Returns Most Recent Push Value - TDD RED
```java
public Object pop() {
  return null;
}
```
### Test 4a - pop1 - Pop Returns Most Recent Push Value - TDD GREEN
```java
public Object pop() {
  return data;
}
```
---
### Test 4b - pop1 - Pop Throws EmptyStackException If Stack is Empty - TDD Test
```java
@Test(expected = EmptyStackException.class)
public void pop_ThrowsEmptyStackException_IfStackIsEmpty() {
  stack.pop();
}
```
### Test 4b - pop1 - Pop Throws EmptyStackException If Stack is Empty - TDD GREEN
```java
public Object pop() {
  if(isEmpty()){
    throw new EmptyStackException();
  }
  return data;
}
```
---
### Test 5 - pop2 - Peek Returns Null After Pop is Called - TDD Test
```java
@Test
public void peek_ReturnsNull_IfPopIsCalled() {
  stack.push(4);
  stack.pop();
  assertNull(stack.peek());
}
```
### Test 5 - pop2 - Peek Returns Null After Pop is Called - TDD GREEN
```java
public Object pop() {
  if(isEmpty()){
    throw new EmptyStackException();
  }
  Object temp = data;
  data = null;
  return temp;
}
```
---
### Test 6 - pop3 - isEmpty Returns True After Calling Pop - TDD GREEN (Sanity Check)
```java
@Test
public void isEmpty_ReturnsTrue_IfPopIsCalled(){
  stack.push(5);
  stack.pop();
  assertTrue(stack.isEmpty());
}
```
---
### Test 7 - Implement Linked List - Push Twice, Pop Once, Then Peek Returns First Value - TDD Test
```java
@Test
public void peek_ReturnsFirstValue_IfPushTwice_PopOnce() {
  stack.push(6);
  stack.push(7);
  stack.pop();
  assertEquals(6, stack.peek());
}
```
**COMMENT THE TEST OUT SO YOU SHOW THEM THAT YOU SHOULD HAVE ALL TESTS PASSING WHEN YOU REFACTOR**
### Test 7 - Implement Linked List - TDD REFACTOR (Node Class + Head Variable)
```java
class Node {
  Object data;
  Node next;
}

Node head;
```
### Test 7 - Implement Linked List - TDD REFACTOR (isEmpty)
```java
public boolean isEmpty() {
  return head == null;
}
```
### Test 7 - Implement Linked List - TDD REFACTOR (push)
```java
public void push(Object data) {
  Node newNode = new Node();
  newNode.data = data;
  newNode.next = head;
  head = newNode;
}
```
### Test 7 - Implement Linked List - TDD REFACTOR (peek)
```java
public Object peek() {
  if(isEmpty()){
    return null;
  }
  return head.data;
}
```
### Test 7 - Implement Linked List - TDD REFACTOR (pop)
```java
public Object pop() {
  if(isEmpty()){
    throw new EmptyStackException();
  }
  Object temp = head.data;
  head = head.next;
  return temp;
}
```
**UNCOMMENT OUT THE TEST AND MAKE SURE IT PASSES**

---
### Test 8a - contains - Contains Returns True if Provided Value is Present - TDD Test
```java
@Test
public void contains_ReturnsTrue_IfValueIsPresent() {
  stack.push(8);
  stack.push(9);
  assertTrue(stack.contains(8));
}
```
### Test 8a - contains - Contains Returns True if Provided Value is Present - TDD RED
```java
public boolean contains(Object data) {
  return false;
}
```
### Test 8a - contains - Contains Returns True if Provided Value is Present - TDD GREEN
```java
public boolean contains(Object data) {
  return true;
}
```
---
### Test 8b - contains - Contains Returns True if Provided Value is NOT Present - TDD Test
```java
@Test
public void contains_ReturnsFalse_IfValueIsNotPresent() {
  stack.push(10);
  stack.push(11);
  assertFalse(stack.contains(12));
}
```
### Test 8b - contains - Contains Returns True if Provided Value is NOT Present - TDD RED
```java
public boolean contains(Object data) {
  return true;
}
```
### Test 8b - contains - Contains Returns True if Provided Value is NOT Present - TDD GREEN
```java
public boolean contains(Object data) {
Node nodeToIterate = head;

while(nodeToIterate != null) {
  if(nodeToIterate.data.equals(data)) {
    return true;
  }
  nodeToIterate = nodeToIterate.next;
}
return false;
}
```
---
**MAIN INTERVIEW IS DONE! Bonus questions ahead!**

---
### BONUS 1 - size - Size Returns Number of Elements in Stack (Tracked By Variable) - TDD Test
```java
@Test
public void size_ReturnsValueOfElementsInStack_TrackedByVariable() {
  stack.push(12);
  stack.push(13);
  stack.push(14);
  assertEquals(3, stack.size());
}
```
### BONUS 1 - size - Size Returns Number of Elements in Stack (Tracked By Variable) - TDD RED
```java
public int size() {
  return 0;
}
```
### BONUS 1 - size - Size Returns Number of Elements in Stack (Tracked By Variable) - TDD GREEN
```java
int counter;

public void push(Object data) {
  Node newNode = new Node();
  newNode.data = data;
  newNode.next = head;
  head = newNode;
  counter++;
}

public Object pop() {
  if(isEmpty()){
      throw new EmptyStackException();
  }
  Object temp = head.data;
  head = head.next;
  counter--;
  return temp;

}

public int size() {
  return counter;
}
```
--- 
### Test BONUS 2 - peekN 1 - peekN Returns Value of Stack at Specific Index - TDD Test
```java
@Test
public void peekN_ReturnsValueOfStack_GivenASpecificIndex() {
  stack.push(15);
  stack.push(16);
  stack.push(17);
  stack.push(18);
  assertEquals(16, stack.peekN(2));
}
```
### Test BONUS 2 - peekN 1 - peekN Returns Value of Stack at Specific Index - TDD RED
```java
public Object peekN(int value) {
  return null;
}
```
### Test BONUS 2 - peekN 1 - peekN Returns Value of Stack at Specific Index - TDD GREEN
```java
public Object peekN(int value) {
  Node nodeToIterate = head;

  while(value != 0) {
    nodeToIterate = nodeToIterate.next;
    value--;
  }
  return nodeToIterate.data;
}
```
---
### Test BONUS 3 - peekN 2 - peekN Returns Null if No Value Exists at Specific Index - TDD Test
```java
@Test
public void peekN_ReturnsNull_IfNoValueExistsAtSpecificIndex() {
  stack.push(19);
  stack.push(20);
  assertNull(stack.peekN(3));
}
```
### Test BONUS 3 - peekN 2 - peekN Returns Null if No Value Exists at Specific Index - TDD GREEN
```java
public Object peekN(int value) {
  if(counter <= value) {
    return null;
  }
  Node nodeToIterate = head;

  while(value != 0) {
    nodeToIterate = nodeToIterate.next;
    value--;
  }
  return nodeToIterate.data;
}
```
---
### Test BONUS 4 - peekN 3 - peekN with Negative Index throws IllegalArgumentException - TDD Test
```java
@Test(expected = IllegalArgumentException.class)
public void peekN_ThrowsIllegalArgumentException_GivenNegativeIndex() {
  stack.peekN(-1);
}
```
### Test BONUS 4 - peekN 3 - peekN with Negative Index throws IllegalArgumentException - TDD GREEN
```java
public Object peekN(int value) {
  if(value < 0) {
    throw new IllegalArgumentException();
  }

  if(counter <= value) {
    return null;
  }
  Node nodeToIterate = head;

  while(value != 0) {
    nodeToIterate = nodeToIterate.next;
    value--;
  }
  return nodeToIterate.data;
}
```