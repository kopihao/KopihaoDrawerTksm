# KopihaoDrawerTksm

_Nothing reinvent, merely utilize [Tang Ke's slide menu](https://github.com/TangKe/SlideMenu) ._

## Platform
- Android

## Why use this
1. Tang Ke's slide menu (*hereinafter tksm*) is awesome
2. Souce code of tksm is included in this project
3. Lazier (*might not simpler, idk*) way to use slide menu
4. No need to understand tksm source code deeply

	_However, understand how to use tksm will help u to customize tksm at full potential_


## Why TK SlideMenu
* Alternative to drawer layout
* Competitive as jfeinstein10 SlidingMenu
* Left and right menu supported
* Left and right menu underlying below main view

## How it behave
1. Exactly as tksm.

## How to use
_Everything based on demo provided._ <br>

>#### Steps :
> 1. Copy src/everything under **com.view.plugin.tksm**
> 2. Copy res/values/tk_sm_attrs.xml
> 2. Define layout, explain later
> 3. Some code to be overwritten in your Activity, also..later...

---

_Left menu(*hereinafter LSM*) and Right menu(*hereinafter RSM*)_<br>


> ##### 3 layout to be defined in res/layout:
> 1. tksm - lay_slidemenu_tangke
> 2. left menu - lay_app_lsm
> 3. right menu -lay_app_rsm
> 4. main view - lay_app_template

> ##### Illustration:<br>
>|LSM|Main_View|RSM|<br>

 ---

In your Main_View :
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tksm="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tksm:layout_role="content"
    android:orientation="vertical" >
```
**layout_role="content"** is compulsory.

In your LSM :
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tksm="http://schemas.android.com/apk/res-auto"
    android:id="@+id/vLSM"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_marginRight="100dp"
    tksm:layout_role="primaryMenu"
    android:background="@android:color/holo_orange_dark" >
```
**layout_role="primaryMenu"** is compulsory.<br>


In your RSM :
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tksm="http://schemas.android.com/apk/res-auto"
    android:id="@+id/vRSM"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_marginLeft="150dp"
    tksm:layout_role="secondaryMenu"
    android:background="@android:color/holo_blue_dark" >
```
**layout_role="secondaryMenu"** is compulsory.

---

In your Activity class:

```java
public void setContentView(int pLayid) {
		super.setContentView(R.layout.lay_slidemenu_tangke);
		mgrTKSM = new TKSlideMenuManager(this, (TKSlideMenu) findViewById(R.id.tksm));
		mgrTKSM.setUI(R.layout.lay_app_template);
		mgrTKSM.setUI(R.layout.lay_app_lsm);
		mgrTKSM.setUI(R.layout.lay_app_rsm);

		// Can be written in this way also
        // mgrTKSM.setUI(R.layout.lay_app_template, R.layout.lay_app_lsm,
		// R.layout.lay_app_rsm);

		mgrTKSM.configure(new TKSlideMenuConfig());

		if (pLayid != 0) {
			View vAppContent = findViewById(R.id.vAppContent);
			if (vAppContent == null) {
				final String MSG_INCOMPATIBLE = "<Layout Incompact>\n"
						+ "Not compatible to app template, anomalies expected";
				popShortToast(MSG_INCOMPATIBLE);
				return;
			}
			inflateUI(vAppContent, pLayid);
		}
		mgrTKSM.close();
}
```

What you do in code snippet above:
* tell TKSlideMenuManager your layouts _(LSM, RSM, MainView)_
* configure with TKSlideMenuConfig _(you may change the value inside)_
* inflate your current activity layout into app_template _(you might change the way setContentView() behave)_
* show MainView

What TKSlideMenuManager do:

|Action|How to|
|:---|:---|
|Open LSM | mgrTKSM.openLeft()|
|Open RSM | mgrTKSM.openRight()|
|Show Mainview | mgrTKSM.close()|


## How to customize

### LAYOUT

Left menu(*hereinafter LSM*) and Right menu(*hereinafter RSM*) is designed as view group type, FrameLayout.

You may customize lsm (*lay_app_lsm in demo app*) and<br>
rsm (*lay_app_rsm in demo app*) according to your project requirement,
by
> **changing layout** (as ListView, GridView, etc)
>
> _OR_
>
> **inflate custom layout/fragment** into it.

<br><br>

### TKSlideMenuConfig

It attempts to initialize tksm.
```java
	private Interpolator interpolator = TKSlideMenu.DEFAULT_INTERPOLATOR;
	private boolean lockLeft = false;
	private boolean lockRight = false;
	private boolean slideContent = true;
	private int slideSensitivity = 0;
	private int shadowLeft = 8;
	private int shadowRight = 8;
```
|Attribute|Value|
|:---|:---|
|interpolator|Interpolator class.<br>eg. LINEAR_INTERPOLATOR, LINEAR_INTERPOLATOR, <br> OR your own version of Interpolator |
|lockLeft|true to disable swipe to left gesture, vice versa|
|lockRight|true to disable swipe to right gesture, vice versa|
|slideContent|true is MODE_SLIDE_CONTENT, <br> false is MODE_SLIDE_WINDOW |
|slideSensitivity|Larger sensitivity will detect more swipe area from screen edge.<br> **but** value 0 will detect whole screen. |
|shadowLeft|shadow width of LSM|
|shadowRight|shadow width of RSM|


You can initialize more tksm attributes via this and enhance method in TKSlideMenu
```java
	public void configure(TKSlideMenuConfig pConfig) {
```

## Things to take note
- This project is build on latest version of tksm (last check 30/09/2015)
- Might not be maintained if tksm is updated by its author.
- Well, text me if you feel upgrade is needed, I will update when I'm free.

## Dependancy
_No string attached. Download and deploy._

## License

```
Copyright (C) 2015 Kopihao

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```














