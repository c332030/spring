<script>
    var url = '${toUrl}';

    if ('' == url) {
        url = location.toString();

        var num = 0;
        var index = 0;
        for(; index < url.length; index++) {

            if('/' == url.charAt(index)) {
                if((++num) == 3) {
                    break;
                }
            }
        }

        url = url.substring(0, index);
    }

    location = url;
</script>