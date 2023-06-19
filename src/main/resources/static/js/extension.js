String.Format = function () {
  let s = arguments[0];
  for (let i = 1; i < arguments.length; i++) {
    const regEx = new RegExp("\\{" + (i - 1) + "\\}", "gm");
    s = s.replace(regEx, arguments[i]);
  }
  return s;
}