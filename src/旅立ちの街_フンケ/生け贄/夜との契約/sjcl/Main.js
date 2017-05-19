
var size;
var magic = [];

(function main() {
    process.stdin.resume();
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function (chunk) {
        // let array = chunk.toString().split("\n");
        // size = +array[0];
        // for (var i = 1; i < array.length-1; i++)
        //     putLine(array[i]);
        // fix();
        // magic.forEach(function(element) {
        //     console.log(element.join(' '));
        // });
        // reset();
        // デバッグ用
        if (size !== undefined) {
            putLine(chunk.toString());
            if (size == magic.length) {
                fix();
                magic.forEach(function(element) {
                    console.log(element.join(' '));
                });
                reset();
            }
        } else
            size = +chunk.toString();
    });
})();

function putLine(line) {
    let array = [];
    line.split(" ").forEach(function(element) {
        array.push(+element);
    });
    magic.push(array);
}

function getSum() { 
    for (var i = 0; i < size; i++) {
        let w = getWidgh(i);
        if (!w.some(isNotComplete))
            return getArraySum(w);
        let h = getHeight(i);
        if (!h.some(isNotComplete))
            return getArraySum(h);
    }
}

function isNotComplete(element, index, array) {
    return element === 0;
}

function getArraySum(array) {
    var sum = 0;
    array.forEach(function(element) {
        sum += element;
    });
    return sum;
}

function getWidgh(y) {
    return magic[y];
}

function getHeight(x) {
    let array = [];
    for (var i = 0; i < size; i++)
        array.push(magic[i][x]);
    return array;
}

function getZeroCount(array) {
    var c = 0;
    array.forEach(function(element) {
        if (element === 0)
            c++;
    });
    return c;
}

function fix() {
    let sum = getSum();
    var skipped = false;
    do {
        var b = false;
        magic.forEach(function(element1, index1) {
            element1.forEach(function(element2, index2) {
                if (element2 === 0) {
                    let fill = function() {
                        if (getZeroCount(element1) <= 1)
                            return sum - getArraySum(element1);
                        let h = getHeight(index2);
                        if (getZeroCount(h) <= 1)
                            return sum - getArraySum(h);
                        return;
                    };
                    var num = fill();
                    if (num !== undefined) {
                        magic[index1][index2] = num;
                        if (!b)
                            skipped = false;
                    } else {
                        b = true;
                        skipped = true;
                    }
                }
            });
        });
    } while(skipped);
}

function reset() {
    size = undefined;
    magic = [];
}
