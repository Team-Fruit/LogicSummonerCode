
var size;
var magic = [];

let getArraySum = function (array) {
    var sum = 0;
    array.forEach(function (element) {
        sum += element;
    });
    return sum;
};

let isNotComplete = function (element, index, array) {
    return element === 0;
};

let getWidth = function (y) {
    return magic[y];
};

let getHeight = function (x) {
    let array = [];
    for (var i = 0; i < size; i++)
        array.push(magic[i][x]);
    return array;
};

let getSlant = function (x) {
    let array = [];
    var h = size - 1;
    for (var i = 0; i < size; i++) {
        if (x === 0)
          array.push(magic[i][i]);
        else if (x === size -1)
          array.push(magic[h][i]);
        h--;
    }
    return array;
};

let getSum = function () {
    for (var i = 0; i < size; i++) {
        let w = getWidth(i);
        if (!w.some(isNotComplete))
            return getArraySum(w);
        let h = getHeight(i);
        if (!h.some(isNotComplete))
            return getArraySum(h);
    }
    let ls = getSlant(0);
    if (!ls.some(isNotComplete))
        return getArraySum(ls);
    let rs = getSlant(size - 1);
    if (!rs.some(isNotComplete))
        return getArraySum(rs);
};

let getZeroCount = function (array) {
    var c = 0;
    array.forEach(function (element) {
        if (element === 0)
            c++;
    });
    return c;
};

let fill = function (sum, index1, index2) {
    if (getZeroCount(magic[index1]) <= 1)
        return sum - getArraySum(magic[index1]);
    let h = getHeight(index2);
    if (getZeroCount(h) <= 1)
        return sum - getArraySum(h);
    return;
};

let fix = function () {
    let sum = getSum();
    var skipped = false;
    do {
        var b = false;
        for (var index1 = 0; index1 < magic.length; index1++) {
            for (var index2 = 0; index2 < magic[index1].length; index2++) {
                if (magic[index1][index2] === 0) {
                    var num = fill(sum, index1, index2);
                    if (num !== undefined) {
                        magic[index1][index2] = num;
                        if (!b)
                            skipped = false;
                    } else {
                        b = true;
                        skipped = true;
                    }
                }
            }
        }
    } while (skipped);
};

let putLine = function (line) {
    let array = [];
    line.split(" ").forEach(function (element) {
        array.push(+element);
    });
    magic.push(array);
};

let reset = function () {
    size = undefined;
    magic = [];
};

(function main() {
    process.stdin.resume();
    process.stdin.setEncoding('utf8');
    process.stdin.on('data', function (chunk) {
        let array = chunk.toString().split("\n");
        size = +array[0];
        for (var i = 1; i < array.length-1; i++)
            putLine(array[i]);
        fix();
        magic.forEach(function(element) {
            console.log(element.join(' '));
        });
        reset();
        // デバッグ用
        // if (size !== undefined) {
        //     putLine(chunk.toString());
        //     if (size == magic.length) {
        //         fix();
        //         magic.forEach(function (element) {
        //             console.log(element.join(' '));
        //         });
        //         reset();
        //     }
        // } else
        //     size = +chunk.toString();
    });
})();
