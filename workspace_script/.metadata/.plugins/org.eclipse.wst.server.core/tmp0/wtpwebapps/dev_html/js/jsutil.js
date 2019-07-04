//el : $("#id") - span태그, 바꾸고자하는 값 12-자식노드
function replaceText(el,text) { 
    if(el!=null) { //span태그가 존재
        //기존 텍스트노드에 들어있는 값은 초기화
        clearText(el);
        //새로운 텍스트 노드 추가
        var newNode = document.createTextNode(text);
        el.appendChild(newNode);
    }
}
//** 파라미터로 넘어온 태그에 값을 지우는 함수 **/
function clearText(el) {
    if(el!=null) {
        if(el.childNodes) {//0만 false
            for(var i=0;i<el.childNodes.length;i++) {
                var childNode = el.childNodes[i];
                el.removeChild(childNode);
            }
        }
    }
}
//텍스트노드의 값을 읽어오는 메소드
//@param-노드의 주소번지
function getText(el) {//el -> $("#id")
    var text="";
    if(el!=null) {//태그가 존재하지 않으면 
        if(el.childNodes) {//태그안에 여러개 노드가 있으면 브라우저가 자동으로 컬렉션(배열)으로 담음
            for(var i=0; i<el.childNodes.length;i++) {
                //여러개 노드 중 한개 - 700000
                var childNode = el.childNodes[i];
                //너 텍스트 노드니?
                //nodeName : 태그의 이름을 읽어옴 - span, div...
                if(childNode.nodeValue!=null) {//700000!=null
                    text = text+childNode.nodeValue;
                }
            }
        }
    }
    return text;
}