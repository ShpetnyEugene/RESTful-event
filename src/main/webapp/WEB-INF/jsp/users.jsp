<jsp:include page="elements/header.jsp"/>


<form>
    <label>Name:</label>
    <input type="text" id="name" required>
    <button> Just button</button>
</form>


<script type="text/javascript">
    //    var position = ymaps.geocode(document.getElementById("name"));
    var a = ymaps.geocode(document.getElementById("name"));
    console.log(a);
</script>

<jsp:include page="elements/footer.jsp"/>