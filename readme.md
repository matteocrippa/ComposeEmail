# ComposeEmail

ComposeEmail is a quick way to compose email inside any app and then allow the preferred mail app to deal with it.

## Install

Add to **gradle** in _allprojects_

```
maven { url 'https://jitpack.io' }
```

then add this

```
implementation 'com.github.matteocrippa:ComposeEmail:0.0.4'
```


## Usage

Set once the application context to the shared object

```kotlin
ComposeEmail.shared.context = applicationContext
```

Then you can use it as easy as:

```kotlin
ComposeEmail.shared.send(Configuration.emailTo, Configuration.emailSubject, Configuration.emailMessage, arrayListOf(Database.shared.export()))
```

Here the parameters you can specify in `send` function:

- `to` is a `ArrayList<String>` of email addresses
- `subject` is a `String` that contains the subject of the email
- `message` is a `String` with the body of the email
- `attachments` is an optional `ArrayList<Uri>` linking the attachments
- `intentMessage` is a `String` to promt a message in the intent where the user picks his/her favorite email client
